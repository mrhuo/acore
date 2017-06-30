package com.mrhuo.acore.base

class RestResultTest extends GroovyTestCase {
    RestResult<String> restResult = null
    final int TEST_CODE = 0
    final String TEST_MSG = "OK"
    final String TEST_DATA = "String Data"

    void setUp() {
        super.setUp()
        restResult = new RestResult<String>(TEST_CODE, TEST_MSG, TEST_DATA)
    }

    void tearDown() {
        restResult = null
    }

    void testGetCode() {
        assertEquals(restResult.getCode(), TEST_CODE)
    }

    void testGetMsg() {
        assertEquals(restResult.getMsg(), TEST_MSG)
    }

    void testGetData() {
        assertEquals(restResult.getData(), TEST_DATA)
    }
}
