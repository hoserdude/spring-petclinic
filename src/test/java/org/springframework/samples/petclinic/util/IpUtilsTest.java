package org.springframework.samples.petclinic.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IpUtilsTest {
	
	@Test
	public void TestIsIpv4Valid() throws Exception {
		assertTrue(IpUtils.isIPv4Valid("127.0.0.1"));
		assertTrue(IpUtils.isIPv4Valid("10.1.0.0"));
		assertFalse(IpUtils.isIPv4Valid("foo"));
		assertFalse(IpUtils.isIPv4Valid("127.0.0"));
		assertFalse(IpUtils.isIPv4Valid("127.0"));
		assertFalse(IpUtils.isIPv4Valid("127"));
	}
}
