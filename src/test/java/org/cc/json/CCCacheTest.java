package org.cc.json;

import junit.framework.Assert;
import org.cc.CCTest;
import org.junit.Test;

/**
 *
 * @author william
 */
public class CCCacheTest {

    @Test
    public void test_cache() {
        JSONObject jo1 = CCCache.load(CCTest.base, "dp.metadata", "JOApplyDelete");
        JSONObject jo2 = CCCache.load(CCTest.base, "dp", "metadata.JOApplyDelete");
        Assert.assertEquals(jo1.optString("id"), jo2.optString("id"));
    }

}
