/*
 * Copyright (c) 2015 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.course.java;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ExpressionNonterminal {

    EXPRESSION;

    public static final Map<Enum<?>, List<List<Enum<?>>>> RULE_SET;
    static {
        RULE_SET = new HashMap<>();
        RULE_SET.put(EXPRESSION, Arrays.asList(
                asList(ExpressionTerminal.LEFT_PARENTHESIS, ExpressionNonterminal.EXPRESSION,
                        ExpressionTerminal.RIGHT_PARENTHESIS),
                asList(ExpressionNonterminal.EXPRESSION, ExpressionTerminal.BINARY_OPERATOR,
                        ExpressionNonterminal.EXPRESSION),
                asList(ExpressionNonterminal.EXPRESSION)));
    }

    public static final ExpressionNonterminal START_SYMBOL_TYPE = EXPRESSION;

    private static List<Enum<?>> asList(Enum<?> symbolType) {
        return Collections.<Enum<?>>singletonList(symbolType);
    }

    private static List<Enum<?>> asList(Enum<?>... symbolTypes) {
        return Arrays.asList(symbolTypes);
    }
}