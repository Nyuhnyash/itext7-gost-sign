/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2022 iText Group NV
    Authors: iText Software.

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
package com.itextpdf.svg.renderers.factories;

import com.itextpdf.svg.renderers.ISvgNodeRenderer;

import java.util.Collection;
import java.util.Map;

/**
 * Interface that will provide a mapping from SVG tag names to Renderers that
 * will be able to draw them. It's used in {@link DefaultSvgNodeRendererFactory}
 * to allow customizability in client code, and dependency injection in tests.
 *
 * @deprecated The interface will be removed in 7.2, while its implementation
 * ({@link DefaultSvgNodeRendererMapper}) will be used as our internal class. Users should
 * override {@link ISvgNodeRendererFactory} (or at least {@link DefaultSvgNodeRendererFactory})
 * and should not deal with the mapping class as it's more of an implementation detail.
 */
@Deprecated
public interface ISvgNodeRendererMapper {

    /**
     * Gets the map from tag names to Renderer classes.
     *
     * @return a {@link Map} with Strings as keys and {link @ISvgNodeRenderer}
     * implementations as values
     */
    Map<String, Class<? extends ISvgNodeRenderer>> getMapping();

    /**
     * Get the list of tags that do not map to any Renderer and should be ignored
     * @return a collection of ignored tags
     */
    Collection<String> getIgnoredTags();
}
