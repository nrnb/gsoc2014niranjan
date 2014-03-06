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

import java.io.IOException;

import java.util.List;

import com.google.common.base.Splitter;

/**
 * VEP consequence.
 */
final class VepConsequence
{
    private final String allele;
    private final String[] consequenceTerms;
    private final boolean canonical;


    private VepConsequence(final String allele, final String[] consequenceTerms, final boolean canonical)
    {
        checkNotNull(allele);
        checkNotNull(consequenceTerms);
        this.allele = allele;
        this.consequenceTerms = consequenceTerms;
        this.canonical = canonical;
    }


    String getAllele()
    {
        return allele;
    }

    String[] getConsequenceTerms()
    {
        return consequenceTerms;
    }

    boolean isCanonical()
    {
        return canonical;
    }

    static VepConsequence parse(final String token) throws IOException
    {
        List<String> values = Splitter.on("|").splitToList(token);
        String allele = values.get(0);
        /*

          todo:  the format may vary

ALL.chr22.phase1_release_v3.20101123.snps_indels_svs.genotypes-2-indv-thin-20000bp-trim.vep.vcf:

##INFO=<ID=CSQ,Number=.,Type=String,Description="Consequence type as predicted by VEP. Format: Allele|Gene|Feature|Feature_type|Consequence|cDNA_position|CDS_position|Protein_position|Amino_acids|Codons|Existing_variation|DISTANCE|CANONICAL">


ALL.chr22.phase1_release_v3.20101123.snps_indels_svs.genotypes-2-indv-thin-20000bp-trim.vep-for-gemini.vcf:

##INFO=<ID=CSQ,Number=.,Type=String,Description="Consequence type as predicted by VEP. Format: Consequence|Codons|Amino_acids|Gene|HGNC|Feature|EXON|PolyPhen|SIFT">

         */
        String[] consequenceTerms = values.get(4).split("&");
        boolean canonical = "YES".equals(values.get(12));

        return new VepConsequence(allele, consequenceTerms, canonical);
    }
}