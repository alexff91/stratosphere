/***********************************************************************************************************************
 *
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
 *
 **********************************************************************************************************************/
package eu.stratosphere.api.common.typeutils.base;

import java.io.IOException;

import eu.stratosphere.core.memory.DataInputView;
import eu.stratosphere.core.memory.MemorySegment;



public final class ShortComparator extends BasicTypeComparator<Short> {

	private static final long serialVersionUID = 1L;


	public ShortComparator(boolean ascending) {
		super(ascending);
	}

	@Override
	public int compare(DataInputView firstSource, DataInputView secondSource) throws IOException {
		short s1 = firstSource.readShort();
		short s2 = secondSource.readShort();
		return (s1 < s2 ? -1 : (s1 == s2 ? 0 : 1));
	}

	@Override
	public boolean supportsNormalizedKey() {
		return true;
	}

	@Override
	public int getNormalizeKeyLen() {
		return 2;
	}

	@Override
	public boolean isNormalizedKeyPrefixOnly(int keyBytes) {
		return keyBytes < 2;
	}

	@Override
	public void putNormalizedKey(Short value, MemorySegment target, int offset, int numBytes) {
		if (numBytes == 2) {
			// default case, full normalized key
			int highByte = ((value >>> 8) & 0xff);
			highByte -= Byte.MIN_VALUE;
			target.put(offset, (byte) highByte);
			target.put(offset + 1, (byte) ((value) & 0xff));
		}
		else if (numBytes <= 0) {
		}
		else if (numBytes == 1) {
			int highByte = ((value >>> 8) & 0xff);
			highByte -= Byte.MIN_VALUE;
			target.put(offset, (byte) highByte);
		}
		else {
			int highByte = ((value >>> 8) & 0xff);
			highByte -= Byte.MIN_VALUE;
			target.put(offset, (byte) highByte);
			target.put(offset + 1, (byte) ((value) & 0xff));
			for (int i = 2; i < numBytes; i++) {
				target.put(offset + i, (byte) 0);
			}
		}
	}

	@Override
	public ShortComparator duplicate() {
		return new ShortComparator(ascendingComparison);
	}
}
