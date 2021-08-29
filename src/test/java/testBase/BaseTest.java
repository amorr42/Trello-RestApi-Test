package testBase;
import org.junit.Test;

import pages.BoardPage;
import pages.CardPage;

import java.util.Random;

public class BaseTest {
	
	BoardPage boardPage= new BoardPage();
    CardPage cardPage= new CardPage();
    Random rnd = new Random();

    @Test
    public void apiTest(){

    	boardPage.createBoard("CreateBoard");
    	cardPage.createCard("1");
    	cardPage.createCard("2");
    	cardPage.updateCard("updateCard",rnd.nextInt(1));
    	cardPage.deleteCard(0);
    	cardPage.deleteCard(1);
    	boardPage.deleteBoard();

    }
}
