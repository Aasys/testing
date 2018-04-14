/*
 * @author Aasys Sresta
 * https://github.com/Aasys
 * Copyright (c) 2018.
 */

package aasys.chess.game.generator;

import com.pholser.junit.quickcheck.generator.GenerationStatus;
import com.pholser.junit.quickcheck.generator.Generator;
import com.pholser.junit.quickcheck.random.SourceOfRandomness;

/**
 * Character Generator for junit quickcheck
 */
public class CharGenerator extends Generator<Character> {
    public CharGenerator() {
        super(Character.class);
    }

    public Character generate(SourceOfRandomness sourceOfRandomness, GenerationStatus generationStatus) {
        return sourceOfRandomness.nextChar(Character.MIN_VALUE, Character.MAX_VALUE);
    }

}
