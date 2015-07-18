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
import static org.joou.Unsigned.ulong;


/**
 * An enumeration of acceptable units for representing length information in a manner that can be represented and
 * converted exactly to a certain number of bytes.
 *
 * @author Emily Mabrey (emabrey@users.noreply.github.com)
 */
public enum LengthUnit implements ConvertableLengthUnit {
  
  /**
   * Represents a unit that is exactly 1 byte in length. This {@link LengthUnit} allows for both representation and
   * conversion of byte length information without directly utilizing {@link ConvertableLengthUnit#getLengthInBytes()};
   * instead acceptors of {@link LengthRange} can indicate those representations and conversions in a more intuitive and
   * "in-band" manner. {@link LengthUnit} allows for both representation and conversion of byte size information without
   * directly utilizing {@link ConvertableLengthUnit#getLengthInBytes()}; instead classes can indicate those
   * representations and conversions in a more intuitive and "in-band" manner (see {@link LengthRange} for an example of
   * such conversion)..
   */
  BYTES(1);
  
  /**
   * An unsigned long value representing the exact number of bytes required to represent the length information of this
   * instance of {@link LengthUnit}.
   */
  private final ULong LENGTH_IN_BYTES;
  
  /**
   * A constructor provided to allow for the syntatic sugar of primitive long constants within {@link LengthUnit}
   * instance declarations; this constructor is actually an alias for {@link #LengthUnit(ULong)} and it generates a new
   * instance of {@link LengthUnit} by automatically converting the provided long value into an unsigned long value.
   *
   * @param unitLengthInBytes
   *        A long value that can be converted to an unsigned long value where both values indicate the length of the
   *        newly created {@link LengthUnit} in bytes.
   */
  LengthUnit(long unitLengthInBytes) {
  
    this(ulong(unitLengthInBytes));
  }
  
  /**
   * Generates a new instance of {@link LengthUnit} which has a length in bytes equal to the provided unsigned long
   * value.
   *
   * @param unitLengthnBytes
   *        An unsigned long value indicating the length of the newly created {@link LengthUnit} in bytes.
   */
  LengthUnit(ULong unitLengthnBytes) {
  
    LENGTH_IN_BYTES = unitLengthnBytes;
  }
  
  /**
   * {@inheritDoc}
   *
   * @return An unsigned long value
   */
  @Override
  public ULong getLengthInBytes() {
  
    return LENGTH_IN_BYTES;
  }
  
}
