/*
 * DBeaver - Universal Database Manager
 * Copyright (C) 2010-2020 DBeaver Corp and others
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jkiss.dbeaver.model.impl;

import org.jkiss.dbeaver.model.meta.IPropertyValueTransformer;

/**
 * Object name case transformer
 */
public class DBPositiveNumberTransformer implements IPropertyValueTransformer<Object, Object> {


    @Override
    public Object transform(Object object, Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Number) {
            Number numberValue = (Number) value;
            if (value instanceof Double && numberValue.doubleValue() <= 0.0) {
                return null;
            } else if (value instanceof Float && numberValue.floatValue() <= 0.0) {
                return null;
            } else if (numberValue.longValue() <= 0) {
                return null;
            }
        }

        return value;
    }
}
