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
package org.dishevelled.variation.vcf;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * VCF genome.
 */
public final class VcfGenome
{
    private final String id;
    private final double mixture;
    private final String description;


    VcfGenome(final String id, final double mixture, final String description)
    {
        checkNotNull(id);
        this.id = id;
        this.mixture = mixture;
        this.description = description;
    }


    public String getId()
    {
        return id;
    }

    public double getMixture()
    {
        return mixture;
    }

    public String getDescription()
    {
        return description;
    }
}