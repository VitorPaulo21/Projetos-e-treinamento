package Controler;

import java.util.Random;
import java.util.function.Consumer;

import View.Grid.Grid;
import View.Next.Proximos;
import View.Objects.Block;
import View.Objects.Randomizer;
import View.PontuationScreen.Pontuation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

public class Layout extends BorderPane implements Consumer<Integer> {

	private Grid grid;
	private Randomizer rand;
	private Block actual;
	private Proximos proximos;
	private Pontuation points;
	private Runnable reset;
	public static boolean started;
	private static boolean started2;
	Timeline fiveSecondsWonder;

	public Layout(Runnable reset) {
		this.reset = reset;

		points = new Pontuation(this);

		proximos = new Proximos();

		rand = new Randomizer();

		actual = getRandom();

		grid = new Grid(this);
		grid.newBlock(actual);
		proximos.newBlock(getRandom());
		setCenter(grid);
		setRight(proximos);
		setLeft(points);
		setAlignment(proximos, Pos.TOP_LEFT);

		fiveSecondsWonder = new Timeline(new KeyFrame(Duration.seconds(0.8), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (started && started2) {
					down();
				}
			}
		}));
		fiveSecondsWonder.setCycleCount(Timeline.INDEFINITE);
		fiveSecondsWonder.play();
		started2 = true;
	}

	public void down() {
		if (grid.downY()) {
			grid.stopActual();
			grid.newBlock(proximos.getBlock());
			proximos.newBlock(getRandom());
		}

	}

	public void right() {

		grid.rightMove();

	}

	public void left() {

		grid.leftMove();

	}

	private Block getRandom() {
		rand.reset();

		int pos = rand.getObjetos().size();

		Random rnd = new Random();

		Block blk = rand.getObjetos().get(rnd.nextInt(pos));
//		Block blk = rand.getObjetos().get(0);

		blk.chanceColor();

		return blk;

	}

	public void rotate() {

		grid.rotate();

	}

	public void addPoints() {
		points.addPoints();
	}

	private void reset() {
		fiveSecondsWonder.stop();
		reset.run();

	}

	@Override
	public void accept(Integer t) {
		if (t == 0) {
			addPoints();
		} else {
			reset();
		}
	}

}
