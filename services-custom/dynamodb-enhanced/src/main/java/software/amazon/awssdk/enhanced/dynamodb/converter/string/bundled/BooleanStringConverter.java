/*
 * Copyright 2010-2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.enhanced.dynamodb.converter.string.bundled;

import java.math.BigInteger;
import software.amazon.awssdk.annotations.Immutable;
import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.annotations.ThreadSafe;
import software.amazon.awssdk.enhanced.dynamodb.converter.string.StringConverter;
import software.amazon.awssdk.enhanced.dynamodb.model.TypeToken;

/**
 * A converter between {@link BigInteger} and {@link String}.
 *
 * <p>
 * This converts values to strings using {@link Boolean#toString()}. This converts the literal string values "true" and "false"
 * to a boolean. Any other string values will result in an exception.
 */
@SdkPublicApi
@ThreadSafe
@Immutable
public class BooleanStringConverter implements StringConverter<Boolean> {
    private BooleanStringConverter() { }

    public static BooleanStringConverter create() {
        return new BooleanStringConverter();
    }

    @Override
    public TypeToken<Boolean> type() {
        return TypeToken.of(Boolean.class);
    }

    @Override
    public Boolean fromString(String string) {
        switch (string) {
            case "true": return true;
            case "false": return false;
            default: throw new IllegalArgumentException("Boolean string was not 'true' or 'false': " + string);
        }
    }
}