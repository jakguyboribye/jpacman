package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit).isNotNull();
        assertThat(unit.hasSquare()).isEqualTo(false);
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {

        // square is abstract so gotta do this :(
        Square cursquare = new Square() {
            @Override
            public boolean isAccessibleTo(Unit unit) {
                return false;
            }

            @Override
            public Sprite getSprite() {
                return null;
            }
        };

        unit.occupy(cursquare);          // Unit occupies the square

        assertThat(cursquare).isEqualTo(unit.getSquare());
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square sq1 = new Square() {
            @Override
            public boolean isAccessibleTo(Unit unit) {
                return true;
            }

            @Override
            public Sprite getSprite() {
                return null;
            }
        };

        Square sq2 = new Square() {
            @Override
            public boolean isAccessibleTo(Unit unit) {
                return true;
            }

            @Override
            public Sprite getSprite() {
                return null;
            }
        };

        unit.occupy(sq1);
        unit.occupy(sq2);

        assertThat(sq1.getOccupants()).isEmpty();
        assertThat(sq2.getOccupants()).containsExactly(unit);
        assertThat(unit.getSquare()).isEqualTo(sq2);
    }

}
