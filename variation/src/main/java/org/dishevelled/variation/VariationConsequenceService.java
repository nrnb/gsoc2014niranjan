/*

    dsh-variation  Variation.
    Copyright (c) 2013-2014 held jointly by the individual authors.

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.fsf.org/licensing/licenses/lgpl.html
    > http://www.opensource.org/licenses/lgpl-license.php

*/
package org.dishevelled.variation;

import java.util.List;

/**
 * Variation consequence service.
 *
 * @author  Michael Heuer
 */
public interface VariationConsequenceService
{

    /**
     * Return the variation consequences associated with the specified variation,
     * if any.
     *
     * @param variation variation, must not be null
     * @return the variation consequences associated with the specified variation
     *    or an empty list if none exist
     */
    List<VariationConsequence> consequences(Variation variation);
}
