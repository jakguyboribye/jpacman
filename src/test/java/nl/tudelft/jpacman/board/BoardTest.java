package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import nl.tudelft.jpacman.sprite.Sprite;
import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    void TestBoard1(){
        Square sq = new BasicSquare() {};
        Board board = new Board(new Square[][] { { sq } });
        assertThat(board.squareAt(0, 0)).isEqualTo(sq);
    }

    @Test
    void TestBoard2(){
        Square sq = null;
        Board board = new Board(new Square[][] { { sq } });
        assertThat(board.squareAt(0, 0)).isNull();
    }

}
