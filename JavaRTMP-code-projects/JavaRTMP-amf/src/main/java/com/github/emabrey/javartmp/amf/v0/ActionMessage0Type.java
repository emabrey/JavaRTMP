/*
 * The MIT License
 *
 * Copyright 2015 Emily Mabrey (emilymabrey93@gmail.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.github.emabrey.javartmp.amf.v0;

/**
 * An enumeration of all Action Message Format version 0 types.
 *
 * @author Emily Mabrey (emabrey@users.noreply.github.com)
 */
public enum ActionMessage0Type {
  
  /**
   * The Action Message number type
   */
  NUMBER,
  /**
   * The Action Message boolean type
   */
  BOOLEAN,
  /**
   * The Action Message string type
   */
  STRING,
  /**
   * The Action Message object type
   */
  OBJECT,
  /**
   * The Action Message movieclip type
   */
  MOVIECLIP,
  /**
   * The Action Message null type
   */
  NULL,
  /**
   * The Action Message undefined type
   */
  UNDEFINED,
  /**
   * The Action Message reference type
   */
  REFERENCE,
  /**
   * The Action Message ecma-Array type
   */
  ECMA_ARRAY,
  /**
   * The Action Message object-end type
   */
  OBJECT_END,
  /**
   * The Action Message typed-object type
   */
  TYPED_OBJECT,
  /**
   * The Action Message avmplus-object type
   */
  AVMPLUS_OBJECT,
  /**
   * The Action Message strict-array type
   */
  STRICT_ARRAY,
  /**
   * The Action Message date type
   */
  DATE,
  /**
   * The Action Message long-string type
   */
  LONG_STRING,
  /**
   * The Action Message unsupported type
   */
  UNSUPPORTED,
  /**
   * The Action Message recordset type
   */
  RECORDSET,
  /**
   * The Action Message xml-document type
   */
  XML_DOCUMENT;
}
