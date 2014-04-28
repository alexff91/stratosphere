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

package eu.stratosphere.core.memory;


/**
 * Interface marking a {@link DataInputView} as seekable. Seekable views can set the position where they
 * read from.
 */
public interface SeekableDataInputView extends DataInputView {

	/**
	 * Sets the read pointer to the given position.
	 *
	 * @param position The new read position.
	 *
	 * @throws IOException Thrown, if any I/O related problem occurred such that the input could not
	 *                     be sought to the desired position.
	 */
	public void setReadPosition(long position);
}
