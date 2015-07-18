/*
 * The MIT License
 *
 * Copyright 2015 Emily Mabrey (emilymabrey93@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.github.emabrey.javartmp.core.measurement.length;

import org.joou.ULong;


/**
 * This interface allows the implementation of the {@link LengthRange} class with an automatic unit conversion
 * capability that can convert between units using an accuracy of one whole byte and a maximum size of
 * {@link ULong#MAX_VALUE}; the maximum size is limited only by the maximum size of the unsigned long primitive.
 *
 * @author Emily Mabrey (emabrey@users.noreply.github.com)
 */
public interface ConvertableLengthUnit {
  
  /**
   * The number of bytes the fundamental size of this {@link ConvertableLengthUnit} requires to be represented purely as
   * a sequence of bytes; generally the fundamental size of a unit is a single instance. The accuracy of the byte
   * conversion size is limited to one whole byte value equal or less than {@link ULong#MAX_VALUE}.
   *
   * @return An unsigned long value between 0 and {@link ULong#MAX_VALUE} that represents the byte encoded length of the
   *         fundamental size of this {@link ConvertableLengthUnit}
   */
  ULong getLengthInBytes();
}
