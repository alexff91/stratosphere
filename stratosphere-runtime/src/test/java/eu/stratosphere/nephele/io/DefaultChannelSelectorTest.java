/***********************************************************************************************************************
 * Copyright (C) 2010-2013 by the Stratosphere project (http://stratosphere.eu)
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 **********************************************************************************************************************/

package eu.stratosphere.nephele.io;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import eu.stratosphere.core.io.StringRecord;

/**
 * This class checks the functionality of the {@link DefaultChannelSelector} class.
 *
 */
public class DefaultChannelSelectorTest {

	/**
	 * This test checks the channel selection
	 */
	@Test
	public void channelSelect() {

		final StringRecord dummyRecord = new StringRecord("abc");
		final DefaultChannelSelector<StringRecord> selector = new DefaultChannelSelector<StringRecord>();
		// Test with two channels
		final int numberOfOutputChannels = 2;
		int[] selectedChannels = selector.selectChannels(dummyRecord, numberOfOutputChannels);
		assertEquals(1, selectedChannels.length);
		assertEquals(1, selectedChannels[0]);
		selectedChannels = selector.selectChannels(dummyRecord, numberOfOutputChannels);
		assertEquals(1, selectedChannels.length);
		assertEquals(0, selectedChannels[0]);
	}

}
