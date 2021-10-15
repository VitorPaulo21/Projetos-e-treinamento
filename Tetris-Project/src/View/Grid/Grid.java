package View.Grid;

import java.awt.Color;
import java.util.ArrayList;
import java.util.function.Consumer;

import Controler.Layout;
import View.Objects.Block;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;


public class Grid extends GridPane{

	private int x;
	private int y;
	private ArrayList<Slots> gridList;
	private ArrayList<Slots> actualSlots;
	private ArrayList<Slots> actualSlotsToRotate;
	private ArrayList<Slots> toDestroyList;
	private ArrayList<Slots> toDownList;
	private Block actual;
	private Block actualToRotate;
	private int actualX;
	private int actualY;
	private boolean allow;
	private int count;
	private int aditiveY;
	private int initCount;
	private int i;
	private boolean pass;
	private boolean right;
	private boolean down;
	private boolean left;
	private boolean triyingToRotate;
	private int midX;
	private int midY;
	private int tryCount;
	private Consumer<Integer> points;
	
	
	public Grid(Consumer<Integer> runer) {
		this.points = runer;
		tryCount = 0;
		actualSlots = new ArrayList<Slots>();
		toDownList = new ArrayList<Slots>();
		gridList = new ArrayList<Slots>();
		toDestroyList = new ArrayList<Slots>();
		actualSlotsToRotate = new ArrayList<Slots>();
		for (int i = 0; i < 10; i++) {
			
			for (int j = 0; j < 21; j++) {
				
				Slots slot = new Slots(i, j);
				
				slot.setColor(null);
				
				gridList.add(slot);
				add(slot, i, j);
				
			}
			
		}
		
	}
	
	public void newBlock(Block block) {
		
		if (isLoose()) {
			
			Alert alerta = new Alert(AlertType.WARNING);
			alerta.setTitle("OPS!");
			alerta.setHeaderText("Que pena você perdeu");
			Layout.started = false;
			alerta.showAndWait();
			points.accept(1);
		}
		
        varrer();
		x = 0;
		y = 0;
		count = 0;
		actualSlots.clear();
		aditiveY = 0;
		block.getObjeto().forEach(o -> {
			
			if (o == 2 || o == 1) {
				
				
				
				x = count % (int) block.getType();
				y = (count / (int) block.getType());
				
				
				
				x = (x + 4) - (((int) block.getType() / 2) == 1 
				        && block.getType() == 2 ? 0 
						: ((int) block.getType() / 2));
				Slots slot = new Slots(x, y); 
				slot.setColor(block.getCor());
				
				actualSlots.add(slot);
			}
			count++;
		});
		actual = block;
		try {
			actualToRotate = block.cloneS();
		} catch (CloneNotSupportedException e) {
			System.out.println("erro ao clonar");
		}
		initCount = (int) actualSlots.stream().map(s -> s.getY()).distinct().count();
				
		actualSlots.forEach(s -> {
			s.setY(s.getY() - initCount);
		});
	}
	
	 public boolean downY() {
		
			allow = true;
			
			actualSlots.forEach(s -> {
				
				int nexctY = s.getY() + 1;
				
				if (s.getY() == 19) {
					allow = false;
				} else {
				
					if (nexctY >= 0) {
						Slots slot = getSlotIndex(s, 0, 1);
						if (slot.isFilled() && !slot.isActual() && slot.isStopped()) {
							allow = false;
						} else if (slot.isFilled() && slot.isActual() && !slot.isStopped()) {
							
						}
					}
				}
				
			});
			if (allow) {
				gridList.stream().filter(s -> s.isActual()).forEach(s -> {
					
					s.setColor(null);
					s.setFilled(false);
					s.setActual(false);
					
				});
				actualSlots.forEach(s -> {
					s.setY(s.getY() +1);
					if(s.getY() >= 0) {
						
						gridList.stream().filter(gl -> gl.getX() == s.getX())
						.filter(gl -> gl.getY() == s.getY())
						.findAny()
						.ifPresent(gl -> {
							gl.setColor(s.getColor());
							gl.setFilled(true);
							gl.setActual(true);
						});
						
					}
				});
				if (initCount > 0) {
					initCount--;
				}
				return false;
			} else {
				return true;
			}
			
	}
	
	public void stopActual() {
		
		actualSlots.forEach(s -> {
			
			gridList.stream().filter(gl -> gl.getX() == s.getX())
			.filter(gl -> gl.getY() == s.getY())
			.findAny()
			.ifPresent(gl -> {
				gl.setStopped(true);
				gl.setActual(false);
				
			});
		});
		checkDestroy();
	}
	
	private Slots getSlotIndex(Slots slot, int addX, int addY) {
		
		Slots slots =  gridList.stream().filter(sl -> sl.getX() == (slot.getX() + (addX)))
				.filter(                sl -> sl.getY() == (slot.getY() + (addY)))
				.findAny()
				.get();
		return slots;
	}
	
	public boolean rightMove() {
		
		allow = true;
		
		actualSlots.forEach(s -> {
			
			int nextX = s.getX() + 1;
			
			if (s.getX() == 9) {
				allow = false;
			} else {
			
				if (nextX >= 0 && s.getY() >= 0) {
					Slots slot = getSlotIndex(s, 1, 0);
					if (slot.isFilled() && !slot.isActual() && slot.isStopped()) {
						allow = false;
					} else if (slot.isFilled() && slot.isActual() && !slot.isStopped()) {
						
					}
				}
			}
			
		});
		
		if (allow) {
			
			gridList.stream().filter(s -> s.isActual()).forEach(s -> {
				
				s.setColor(null);
				s.setFilled(false);
				s.setActual(false);
				
			});
			actualSlots.forEach(s -> {
				s.setX(s.getX() +1);
				if(s.getX() >= 0) {
					
					gridList.stream().filter(gl -> gl.getX() == s.getX())
					.filter(gl -> gl.getY() == s.getY())
					.findAny()
					.ifPresent(gl -> {
						gl.setColor(s.getColor());
						gl.setFilled(true);
						gl.setActual(true);
					});
					
				}
			});
			return false;
		} else {
			right = true;
			return true;
		}
		
	}
	public boolean leftMove() {
		
		allow = true;
		
		actualSlots.forEach(s -> {
			
			int nextX = s.getX() - 1;
			
			if (s.getX() == 0) {
				allow = false;
			} else {
				
				if (nextX >= 0 && s.getY() >= 0) {
					Slots slot = getSlotIndex(s, -1, 0);
					if (slot.isFilled() && !slot.isActual() && slot.isStopped()) {
						allow = false;
					} else if (slot.isFilled() && slot.isActual() && !slot.isStopped()) {
						
					}
				}
			}
			
		});
		
		if (allow) {
			
			gridList.stream().filter(s -> s.isActual()).forEach(s -> {
				
				s.setColor(null);
				s.setFilled(false);
				s.setActual(false);
				
			});
			actualSlots.forEach(s -> {
				s.setX(s.getX() - 1);
				if(s.getX() >= 0) {
					
					gridList.stream().filter(gl -> gl.getX() == s.getX())
					.filter(gl -> gl.getY() == s.getY())
					.findAny()
					.ifPresent(gl -> {
						gl.setColor(s.getColor());
						gl.setFilled(true);
						gl.setActual(true);
						gl.setStopped(false);
					});
					
				}
			});
			return false;
		} else {
			return true;
		}
		
	}
	
	private void checkDestroy() {
		
		
		Runnable destroiAll = () -> {
			
			toDestroyList.forEach(s -> {				
				if(s.getY() >= 0) {
					
					gridList.stream().filter(gl -> gl.getX() == s.getX())
					.filter(gl -> gl.getY() == s.getY())
					.findAny()
					.ifPresent(gl -> {
						gl.setColor(s.getColor());
						gl.setFilled(true);
						gl.setActual(false);
						gl.setStopped(true);
					});
					
				}
				
			});
			toDestroyList.clear();
			gridList.stream().filter(s -> s.isFilled() && !s.isActual() && !s.isStopped())
			.forEach(s -> {
				
				s.setColor(null);
				s.setFilled(false);
				s.setStopped(false);
				s.setActual(false);
				
			});
			
		};
		
            for (i = 0; i < 20; i++) {
			boolean destroy = gridList.stream().filter(s -> s.getY() == i).allMatch(s -> s.isFilled() && s.isStopped());
			if (destroy) {
				
				gridList.stream().filter(s -> s.getY() == i).forEach(s -> {
					s.setColor(null);
				});
				
				gridList.stream().filter(s -> s.isFilled() && s.isStopped() && s.getY() <= i).sorted(((l1, l2) -> l1.getY() > l2.getY() ? 0 : 1)).forEach(s -> {
					if(s.getY() > 0) {
						
						Slots slot = new Slots(s.getX(), s.getY() + 1);
						slot.setColor(s.getColor());
						slot.setStopped(true);
						slot.setFilled(true);
						slot.setActual(false);
						
						toDestroyList.add(slot);
						s.setColor(null);
						s.setActual(false);
						s.setFilled(false);
						s.setStopped(false);
					}
				});
				destroiAll.run();
				points.accept(0);
				
			}
			
	
		}
		

		
		toDestroyList.clear();
	}
	
	public void rotate() {
		
		int maxY = actualSlots.stream().map(s -> s.getY()).max((y1, y2) -> y1.compareTo(y2)).get();
		int minY = actualSlots.stream().map(s -> s.getY()).min((y1, y2) -> y1.compareTo(y2)).get();
		int maxX = actualSlots.stream().map(s -> s.getX()).max((x1, x2) -> x1.compareTo(x2)).get();
		int minX = actualSlots.stream().map(s -> s.getX()).min((x1, x2) -> x1.compareTo(x2)).get();
		
		midY = (minY + maxY) / 2; 
		midX = (minX + maxX) / 2; 
		

			actualToRotate.rotate();
			
			x = 0;
			y = 0;
			count = 0;
			actualSlotsToRotate.clear();
			aditiveY = 0;
			actualToRotate.getObjeto().forEach(o -> {

				if (o == 2 || o == 1) {

					x = count % (int) actual.getType();
					y = (count / (int) actual.getType()) + midY;

					x = (x + midX) - (((int) actual.getType() / 2) == 1 && actual.getType() == 2 ? 0
							: ((int) actual.getType() / 2));
					Slots slot = new Slots(x, y);
					slot.setColor(actual.getCor());
					slot.setActual(true);
					slot.setFilled(true);
					slot.setStopped(false);

					actualSlotsToRotate.add(slot);

				}
				count++;
			});
			
			allow();
			if (allow) {
				actual.rotate();
				gridList.stream().filter(s -> s.isActual() && s.isFilled() && !s.isStopped()).forEach(s -> {

					s.setColor(null);
					s.setFilled(false);
					s.setActual(false);
					s.setStopped(false);
				});	

				x = 0;
				y = 0;
				count = 0;
				actualSlots.clear();
				aditiveY = 0;
				actual.getObjeto().forEach(o -> {

					if (o == 2 || o == 1) {

						x = count % (int) actual.getType();
						y = (count / (int) actual.getType()) + midY;

						x = (x + midX) - (((int) actual.getType() / 2) == 1 && actual.getType() == 2 ? 0
								: ((int) actual.getType() / 2));
						Slots slot = new Slots(x, y);
						slot.setColor(actual.getCor());
						slot.setActual(true);
						slot.setFilled(true);
						slot.setStopped(false);

						actualSlots.add(slot);

					}
					count++;
				});
				
				renderize();
				tryCount = 0;
			} else {
				try {
					actualToRotate = actual.cloneS();
				} catch (CloneNotSupportedException e) {
					System.out.println("erro ao clonar");
				}
				simulate();
			}
		}
	
	private void renderize() {
		
		pass = true;	
		actualSlots.forEach(s -> {
			gridList.stream().filter(gl -> gl.getX() == s.getX())
			.filter(gl -> gl.getY() == s.getY())
			.findAny()
			.ifPresent(gl -> {
				gl.setColor(s.getColor());
				gl.setActual(true);
				gl.setFilled(true);
				gl.setStopped(false);
			});
			
		});
		
		
//		}
	}
	private void allow() {
		
		allow = true;
		if (actualSlotsToRotate.stream().allMatch(s -> s.getX() >= 0 )) {
			right = false;
			if (actualSlotsToRotate.stream().allMatch(s -> s.getY() >= 0 )) {
				if (actualSlotsToRotate.stream().allMatch(s -> s.getX() <= 9 )) {
					left = false;
					if (actualSlotsToRotate.stream().allMatch(s -> s.getY() <= 19 )) {
						down = false;
					}else {
						allow = false;
						down = true;
					}
				}else {
					allow = false;
					left = true;
				}
			}else {
				allow = false;
			}
		}else {
			allow = false;
			right = true;
		}
		actualSlotsToRotate.forEach(s -> {
			
			gridList.stream().filter(gl -> gl.getX() == s.getX())
			.filter(gl -> gl.getY() == s.getY())
			.findAny()
			.ifPresent(gl -> {

				 if (gl.isFilled() && !gl.isActual() && gl.isStopped()) {
					allow = false;
					if (gl.getX() < midX) {
						if(!right && !left)
						right = true;
					} else if (gl.getX() > midX) {
						if(!right && !left)
						left = true;
					}
				} else if (gl.isFilled() && gl.isActual() && !gl.isStopped()) {
					
				}
				
			});
			
		});
		
	}
	private void simulate() {
		tryCount++;
		
		if (tryCount <= 5) {
			if (left && right) {
				return;
			}
			if (left && !right) {
				while (!leftMove()) {
					rotate();
				}
			}
			if (right && !left) {
				while (!rightMove()) {
					rotate();
				}
			} 
		}
		
		
		
	}
	
	private void varrer() {
		toDownList.clear();
		gridList.stream().filter(s -> s.getY() == 0 && s.isFilled() && s.isStopped() && !s.isActual()).forEach(s -> toDownList.add(s));
		
			
		toDownList.forEach(s -> {
			Color cor = s.getColor();
			int nexY = gridList.stream()
					.filter(gl -> gl.isFilled() && gl.isStopped() && !gl.isActual() && gl.getY() > 1 && gl.getX() == s.getX())
					.map(gl -> gl.getY())
					.min((gl1,gl2) -> gl1.compareTo(gl2))
					.get() ;
			
			if ((nexY-1) > 1) {
				
				int nexX = s.getX();
				
				s.setColor(null);
				s.setFilled(false);
				s.setActual(false);
				s.setStopped(false);
				gridList.stream()
				.filter(gl -> gl.getX() == nexX)
				.filter(gl -> gl.getY() == (nexY - 1))
				.findAny()
				.ifPresent(gl -> {
					
					gl.setColor(cor);
					gl.setFilled(true);
					gl.setActual(false);
					gl.setStopped(true);
					
				});
			}
			
		});
		
		
	}
	
	private boolean isLoose() {
		
		return gridList.stream().filter(s -> s.getY() == 0)
				.filter(s -> s.getX() > 2 && s.getX() < 6)
				.anyMatch(s -> s.isFilled() && s.isStopped() && !s.isActual());
		
	}
}
