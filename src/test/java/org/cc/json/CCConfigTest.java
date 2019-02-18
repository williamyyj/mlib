package org.cc.json;

import junit.framework.Assert;
import org.cc.CCTest;
import org.junit.Test;

/**
 *
 * @author william
 */
public class CCConfigTest {

    @Test
    public void test_cache() {
        JSONObject cfg = new CCConfig(CCTest.base, "db").params();
        Assert.assertEquals("baphiq.test", cfg.optString("id"));
    }
}
