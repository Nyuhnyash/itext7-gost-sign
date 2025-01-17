/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2023 iText Group NV
    Authors: Bruno Lowagie, Paulo Soares, et al.
    
    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License version 3
    as published by the Free Software Foundation with the addition of the
    following permission added to Section 15 as permitted in Section 7(a):
    FOR ANY PART OF THE COVERED WORK IN WHICH THE COPYRIGHT IS OWNED BY
    ITEXT GROUP. ITEXT GROUP DISCLAIMS THE WARRANTY OF NON INFRINGEMENT
    OF THIRD PARTY RIGHTS
    
    This program is distributed in the hope that it will be useful, but
    WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
    or FITNESS FOR A PARTICULAR PURPOSE.
    See the GNU Affero General Public License for more details.
    You should have received a copy of the GNU Affero General Public License
    along with this program; if not, see http://www.gnu.org/licenses or write to
    the Free Software Foundation, Inc., 51 Franklin Street, Fifth Floor,
    Boston, MA, 02110-1301 USA, or download the license from the following URL:
    http://itextpdf.com/terms-of-use/
    
    The interactive user interfaces in modified source and object code versions
    of this program must display Appropriate Legal Notices, as required under
    Section 5 of the GNU Affero General Public License.
    
    In accordance with Section 7(b) of the GNU Affero General Public License,
    a covered work must retain the producer line in every PDF that is created
    or manipulated using iText.
    
    You can be released from the requirements of the license by purchasing
    a commercial license. Buying such a license is mandatory as soon as you
    develop commercial activities involving the iText software without
    disclosing the source code of your own applications.
    These activities include: offering paid services to customers as an ASP,
    serving PDFs on the fly in a web application, shipping iText with a closed
    source product.
    
    For more information, please contact iText Software Corp. at this
    address: sales@itextpdf.com
 */
package com.itextpdf.styledxmlparser.css.validate.impl.datatype;


import com.itextpdf.styledxmlparser.css.validate.ICssDataTypeValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * {@link ICssDataTypeValidator} implementation for elements in an enumeration.
 */
public class CssEnumValidator implements ICssDataTypeValidator {

    /** The allowed values. */
    private Set<String> allowedValues;

    /**
     * Creates a new {@link CssEnumValidator} instance.
     *
     * @param allowedValues the allowed values
     */
    public CssEnumValidator(String... allowedValues) {
        this.allowedValues = new HashSet<>(Arrays.asList(allowedValues));
    }

    /**
     * Creates a new {@link CssEnumValidator} instance.
     *
     * @param allowedValues the allowed values
     */
    public CssEnumValidator(Collection<String> allowedValues) {
        this(allowedValues, null);
    }

    /**
     * Creates a new {@link CssEnumValidator} instance.
     * <p>
     * Each allowed value will be added with all the modificators.
     * Each allowed value will be added as well.
     *
     * @param allowedValues the allowed values
     * @param allowedModificators the allowed prefixes
     */
    public CssEnumValidator(Collection<String> allowedValues, Collection<String> allowedModificators) {
        this.allowedValues = new HashSet<>();
        this.allowedValues.addAll(allowedValues);
        if (null != allowedModificators) {
            for (String prefix : allowedModificators) {
                for (String value : allowedValues) {
                    this.allowedValues.add(prefix + " " + value);
                }
            }
        }
    }

    /**
     * Adds new allowed values to the allowedValues.
     *
     * @param allowedValues the allowed values
     */
    public void addAllowedValues(final Collection<String> allowedValues) {
        this.allowedValues.addAll(allowedValues);
    }

    /* (non-Javadoc)
     * @see com.itextpdf.styledxmlparser.css.validate.ICssDataTypeValidator#isValid(java.lang.String)
     */
    @Override
    public boolean isValid(String objectString) {
        return allowedValues.contains(objectString);
    }
}
