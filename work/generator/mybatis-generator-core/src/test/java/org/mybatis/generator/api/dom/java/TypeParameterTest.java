/**
 *    Copyright ${license.git.copyrightYears} the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.generator.api.dom.java;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TypeParameterTest {

    @Test
    public void testConstructor() {

        TypeParameter typeParameter = new TypeParameter("T");
        assertNotNull(typeParameter);
        assertEquals("T", typeParameter.getName());
        assertNotNull(typeParameter.getExtendsTypes());
        assertEquals(0, typeParameter.getExtendsTypes().size());
    }

    @Test
    public void testConstructorWIthExtends() {

        FullyQualifiedJavaType list = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType compare = new FullyQualifiedJavaType("java.util.Comparator");

        TypeParameter typeParameter = new TypeParameter("T", Arrays.asList(list, compare));
        assertNotNull(typeParameter);
        assertEquals("T", typeParameter.getName());
        assertNotNull(typeParameter.getExtendsTypes());
        assertEquals(2, typeParameter.getExtendsTypes().size());
    }

    @Test
    public void testGetFormattedContent() {

        FullyQualifiedJavaType list = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType compare = new FullyQualifiedJavaType("java.util.Comparator");

        TypeParameter typeParameter = new TypeParameter("T", Arrays.asList(list, compare));
        assertNotNull(typeParameter);
        assertEquals("T extends List & Comparator", typeParameter.getFormattedContent(null));

        TopLevelClass compilationUnit = new TopLevelClass("java.util.Test");
        assertEquals("T extends List & Comparator", typeParameter.getFormattedContent(compilationUnit));

        TopLevelClass compilationUnit2 = new TopLevelClass("java.lang.Test");
        assertEquals("T extends java.util.List & java.util.Comparator", typeParameter.getFormattedContent(compilationUnit2));
    }

    @Test
    public void testToString() {

        FullyQualifiedJavaType list = FullyQualifiedJavaType.getNewListInstance();
        FullyQualifiedJavaType compare = new FullyQualifiedJavaType("java.util.Comparator");

        TypeParameter typeParameter = new TypeParameter("T", Arrays.asList(list, compare));
        assertNotNull(typeParameter);
        assertEquals("T extends List & Comparator", typeParameter.toString());
    }
}