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

import com.google.common.base.Preconditions;
import java.math.BigInteger;
import lombok.Value;
import org.joou.ULong;
import static org.joou.Unsigned.ulong;


/**
 * An immutable value class used to represent range-based length information in a compound format containing minimum and
 * maximum scalars alongside an associated length unit. The unit information of the {@link LengthRange} class is
 * represented using a value from those enumerated within {@link LengthUnit}, which provides implementations of
 * {@link ConvertableLengthUnit} to allow exact unit conversions in an extensible manner. The length range information
 * of an instance of {@link LengthRange} is represented as an inclusively bounded range between two scalar unsigned
 * longs. This class uses {@link BigInteger} internally to maximize mathematical utility in an overflow-aware manner;
 * note that the exact implementation of {@link LengthRange} is intended to maximize compiler optimizations via usage of
 * static methods to hopefully avoid some of the associated performance costs.
 *
 * @author Emily Mabrey (emabrey@users.noreply.github.com)
 */
@Value
public class LengthRange {
  
  /**
   * Convenience method that provides syntatic sugar for generating {@link LengthRange} instances via a call to
   * {@link #exactly(ULong, LengthUnit)} that uses a {@link ULong} generated from the provided long value.
   *
   * @param exactLengthScalar
   *        A long value containing a positive and non-zero value; this is only a lengthUnit-less scalar.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar value.
   *
   * @return A newly created instance of {@link LengthRange} that represents the provided scalar as an exact number of
   *         the provided lengthUnit.
   */
  public static LengthRange exactly(final long exactLengthScalar, LengthUnit lengthUnit) {
  
    return exactly(ulong(exactLengthScalar), lengthUnit);
  }
  
  /**
   * Convenience method that provides syntatic sugar for generating {@link LengthRange} instances via indirect usage of
   * the {@link #LengthRange(ULong, LengthUnit)} constructor.
   *
   * @param exactLengthScalar
   *        An unsigned long value that is a lengthUnit-less scalar.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar value.
   *
   * @return A newly created instance of {@link LengthRange} that represents the provided scalar as an exact number of
   *         the provided lengthUnit.
   */
  public static LengthRange exactly(final ULong exactLengthScalar, LengthUnit lengthUnit) {
  
    return new LengthRange(exactLengthScalar, lengthUnit);
  }
  
  /**
   * Convenience method that provides syntatic sugar for generating {@link LengthRange} instances via a call to
   * {@link #boundedBetween(ULong, ULong, LengthUnit)}; this method generates {@link ULong} instances from the provided
   * long values.
   *
   * @param minimumLengthScalar
   *        A long value containing a positive and non-zero value; this is only a lengthUnit-less scalar that represents
   *        a minimum possible length.
   * @param maximumLengthScalar
   *        A long value containing a positive and non-zero value; this is only a lengthUnit-less scalar that represents
   *        a maximum possible length.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar values.
   *
   * @return A newly created instance of {@link LengthRange} that represents the provided scalars as a bounded range of
   *         the provided lengthUnit.
   */
  public static LengthRange boundedBetween(final long minimumLengthScalar, final long maximumLengthScalar,
    LengthUnit lengthUnit) {
  
    return boundedBetween(ulong(minimumLengthScalar), ulong(maximumLengthScalar), lengthUnit);
  }
  
  /**
   * Convenience method that provides syntatic sugar for generating {@link LengthRange} instances via indirect usage of
   * the {@link #LengthRange(ULong, ULong, LengthUnit)} constructor.
   *
   * @param minimumLengthScalar
   *        An unsigned long value containing a positive and non-zero value; this is only a lengthUnit-less scalar that
   *        represents a minimum possible length.
   * @param maximumLengthScalar
   *        An unsigned long value containing a positive and non-zero value; this is only a lengthUnit-less scalar that
   *        represents a maximum possible length.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar value.
   *
   * @return A newly created instance of {@link LengthRange} that represents the provided scalar as a bounded range of
   *         the provided lengthUnit.
   */
  public static LengthRange boundedBetween(final ULong minimumLengthScalar, final ULong maximumLengthScalar,
    LengthUnit lengthUnit) {
  
    return new LengthRange(minimumLengthScalar, maximumLengthScalar, lengthUnit);
  }
  
  /**
   * Convenience method that provides syntatic sugar for generating {@link LengthRange} instances via a call to
   * {@link #atLeast(ULong, LengthUnit)} that uses a {@link ULong} generated from the provided long value.
   *
   * @param minimumLengthScalar
   *        An unsigned long value containing a positive and non-zero value; this is only a lengthUnit-less scalar that
   *        represents a minimum possible length.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar value.
   *
   * @return A newly created instance of {@link LengthRange} that represents the provided scalar as a strictly minimum
   *         bounded value of the provided lengthUnit.
   */
  public static LengthRange atLeast(final long minimumLengthScalar, LengthUnit lengthUnit) {
  
    return atLeast(ulong(minimumLengthScalar), lengthUnit);
  }
  
  /**
   * Convenience method that provides syntatic sugar for generating {@link LengthRange} instances via indirect usage of
   * the {@link #boundedBetween(ULong, ULong, LengthUnit)} method.
   *
   * @param minimumLengthScalar
   *        An unsigned long value containing a positive and non-zero value; this is only a lengthUnit-less scalar that
   *        represents a minimum possible length.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar value.
   *
   * @return A newly created instance of {@link LengthRange} that represents the provided scalar as a strictly minimum
   *         bounded value of the provided lengthUnit.
   */
  public static LengthRange atLeast(final ULong minimumLengthScalar, LengthUnit lengthUnit) {
  
    return boundedBetween(minimumLengthScalar, ulong(ULong.MAX_VALUE), lengthUnit);
  }
  
  /**
   * Generates a new instance of {@link LengthRange} with exactly equal minimum and maximum length bounds represented
   * using the indicated lengthUnit.
   *
   * @param exactLengthScalar
   *        An unsigned long scalar that indicates an exact length.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar value.
   */
  public LengthRange(final ULong exactLengthScalar, final LengthUnit lengthUnit) {
  
    this(exactLengthScalar, exactLengthScalar, lengthUnit);
  }
  
  /**
   * Generates a new instance of {@link LengthRange} with an inclusively bounded range of potential lengths that utilize
   * the indicated lengthUnit.
   *
   * @param minimumLengthScalar
   *        An unsigned long scalar that indicates the inclusive lower bound of potential lengths.
   * @param maximumLengthScalar
   *        An unsigned long scalar that indicates the inclusive upper bound of potential lengths.
   * @param lengthUnit
   *        The lengthUnit of this {@link LengthRange} instance; this lengthUnit qualifies the scalar value.
   */
  public LengthRange(final ULong minimumLengthScalar, final ULong maximumLengthScalar, final LengthUnit lengthUnit) {
  
    Preconditions.checkArgument(maximumLengthScalar.compareTo(minimumLengthScalar) >= 0);
    
    this.minimumLengthScalar = minimumLengthScalar;
    this.maximumLengthScalar = maximumLengthScalar;
    this.lengthUnit = lengthUnit;
  }
  
  /**
   * Generates a new instance of {@link LengthRange} which uses the provided {@link LengthUnit} to represent the exact
   * same length information represented by this {@link LengthRange} instance. The calculation is performed using
   * {@link BigInteger} to avoid overflowing the unsigned long type. The final scalar lengths of the newly generated
   * {@link LengthRange} may not exceed the maximum value of an unsigned long without generating an exception, however
   * all intermediate calculations avoid conversions and will successfully and temporarily overflow an unsigned long to
   * the extent permitted by {@link BigInteger}.
   *
   * @param desiredLengthUnit
   *        The desired unit of the newly generated {@link LengthRange}
   *
   * @return A newly generated {@link LengthRange} using the desired lengthUnit to represent the same length information
   *         of this {@link LengthRange} instance.
   */
  public LengthRange convertedTo(final LengthUnit desiredLengthUnit) {
  
    final ULong convertedMinimumBoundScalar =
      calculateScalarUnitConversion(getMinimumLengthScalar(), desiredLengthUnit);
    final ULong convertedMaximumBoundScalar =
      calculateScalarUnitConversion(getMaximumLengthScalar(), desiredLengthUnit);
    
    return new LengthRange(convertedMinimumBoundScalar, convertedMaximumBoundScalar, desiredLengthUnit);
  }
  
  /**
   * Indicates if this {@link LengthRange} can be represented as a single exact and finite numerical scalar using the
   * current {@link LengthUnit}.
   *
   * @return A boolean value of true to indicate that this {@link LengthRange} has exactly equal minimum and maximum
   *         bounds; false otherwise.
   */
  public boolean isExact() {
  
    final BigInteger minimumLengthBigInt = getMinimumLengthScalar().toBigInteger();
    final BigInteger maximumLengthBigInt = getMaximumLengthScalar().toBigInteger();
    
    return minimumLengthBigInt.equals(maximumLengthBigInt);
  }
  
  /**
   * Utilizes {@link BigInteger} to provided conversion of this {@link LengthRange} scalar value to a new scalar value
   * representing an equal length but instead using the indicated desired lengthUnit; the provided scalar is interpreted
   * using the {@link LengthUnit} returned by {@link #getLengthUnit()}.
   *
   * @param scalar
   *        The unsigned long scalar that is to be converted
   * @param desiredLengthUnit
   *        The desired lengthUnit of the newly calculated scalar
   *
   * @return An unsigned long scalar using the provided desired unit to represent the length information of the provided
   *         scalar.
   */
  private ULong calculateScalarUnitConversion(ULong lengthScalar, LengthUnit desiredLengthUnit) {
  
    final BigInteger currentUnitSizeInBytes = getLengthUnit().getLengthInBytes().toBigInteger();
    final BigInteger desiredUnitSizeInBytes = desiredLengthUnit.getLengthInBytes().toBigInteger();
    
    final BigInteger currentLengthScalar = lengthScalar.toBigInteger();
    final BigInteger desiredLengthScalar =
      currentLengthScalar.multiply(currentUnitSizeInBytes).divide(desiredUnitSizeInBytes);
    
    return ulong(desiredLengthScalar);
  }
  
  /**
   * The scalar value indicating the minimum possible value of the inclusive range of potential lengths this
   * {@link LengthRange} represents.
   */
  ULong minimumLengthScalar;
  
  /**
   * The scalar value indicating the maximum possible value of the inclusive range of potential lengths this
   * {@link LengthRange} represents.
   */
  ULong maximumLengthScalar;
  
  /**
   * The unit information of this {@link LengthRange} stored in an immutable fashion.
   */
  LengthUnit lengthUnit;
}
