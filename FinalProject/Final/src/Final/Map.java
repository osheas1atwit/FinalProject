package Final;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Map extends Application{
	Stage gameplay = new Stage();
	Battle background = new Battle();
	
	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////   START OF GAME  / MAIN MENU    //////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	
	public void start(Stage game) throws FileNotFoundException {

		gameplay.setWidth(1920); gameplay.setHeight(1080);
		
		Image splashView = new Image(new FileInputStream("FinalProject/assets/menu/menuSplash.png"));
			ImageView splash = new ImageView(splashView);
			
		Image playView = new Image(new FileInputStream("FinalProject/assets/menu/playButton.png"));
			ImageView play = new ImageView(playView);
			play.setOnMouseClicked(new EventHandler <MouseEvent>(){
				
				@Override
				public void handle(MouseEvent click) {
					try {
						Scene map = map();
						gameplay.setScene(map);
						
					} catch (FileNotFoundException e) {
						System.out.println("IMAGE NOT FOUND");
						System.exit(0);
					}
				}
				
			});
			
			
		Image quitView = new Image(new FileInputStream("FinalProject/assets/menu/quitButton.png"));
			ImageView quit = new ImageView(quitView);
			quit.setOnMouseClicked(new EventHandler <MouseEvent>(){
				
				@Override
				public void handle(MouseEvent click) {
					System.exit(0);
				}
				
			});
			
	
		GridPane mainMenuButtonLayer = new GridPane();
			mainMenuButtonLayer.setHgap(450);
			mainMenuButtonLayer.setPadding(new Insets(775, 0, 10, 250));
			mainMenuButtonLayer.add(play, 1, 0);
			mainMenuButtonLayer.add(quit, 2, 0);
			GridPane.setValignment(quit, VPos.BOTTOM);
			
		StackPane background = new StackPane();
			background.getChildren().add(splash);
			background.getChildren().add(mainMenuButtonLayer);

		
		Scene menu = new Scene(background, 1920, 1080);
			
		gameplay.setScene(menu);
		gameplay.show();

	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////       BONFIRE              //////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	
	public Scene bonfire() throws FileNotFoundException{
		
		Image starsView = new Image(new FileInputStream("FinalProject/assets/scenes/bonfire.png"));
			ImageView stars = new ImageView(starsView);
			
		Image yesRestView = new Image(new FileInputStream("FinalProject/assets/scenes/yesRest.png"));
			ImageView yesRest = new ImageView(yesRestView);
			
		yesRest.setOnMouseClicked(new EventHandler <MouseEvent>(){
			
			@Override
			public void handle(MouseEvent click) {
					background.BonfireHeal();
					background.StageIncrease();
					try {
						Scene map = map();
						gameplay.setScene(map);
					} catch (FileNotFoundException e) {
						System.out.println("IMAGE NOT FOUND");
						System.exit(0);
					}
				}
		});
			
		Image noRestView = new Image(new FileInputStream("FinalProject/assets/scenes/noRest.png"));
			ImageView noRest = new ImageView(noRestView);
		
			noRest.setOnMouseClicked(new EventHandler <MouseEvent>(){
				
				@Override
				public void handle(MouseEvent click) {
					background.StageIncrease();
					try {
						Scene arena = arena();
						gameplay.setScene(arena);
						
					} catch (FileNotFoundException e) {
						System.out.println("IMAGE NOT FOUND");
						System.exit(0);
					}
				}
				
			});
		
		GridPane RestButtonLayer = new GridPane();
			RestButtonLayer.setPadding(new Insets(390, 10, 10, 1100));
			RestButtonLayer.add(yesRest, 1, 1);
			RestButtonLayer.add(noRest, 2, 1);	
		
		StackPane fireBackground = new StackPane();
			fireBackground.getChildren().add(stars);
			fireBackground.getChildren().add(RestButtonLayer);
	
		
		Scene fire = new Scene(fireBackground, 1920, 1080);
		return fire;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////              MAP            //////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////

	
	public Scene map() throws FileNotFoundException{
		
		Image paperView = new Image(new FileInputStream("FinalProject/assets/scenes/map.png"));
		ImageView paper = new ImageView(paperView);
	
		Image enemyView = new Image(new FileInputStream("FinalProject/assets/scenes/fightIcon.png"));
			ImageView enemy1 = new ImageView(enemyView);
				enemy1.setOnMouseClicked(new EventHandler <MouseEvent>(){
					
					@Override
					public void handle(MouseEvent click) {
						try {
							Scene arena = arena();
							gameplay.setScene(arena);
							
						} catch (FileNotFoundException e) {
							System.out.println("IMAGE NOT FOUND");
							System.exit(0);
						}
					}
					
				});
			
			ImageView miniboss = new ImageView(enemyView);
				miniboss.setOnMouseClicked(new EventHandler <MouseEvent>(){
					
					@Override
					public void handle(MouseEvent click) {
						try {
							Scene arena = arena();
							gameplay.setScene(arena);
							
						} catch (FileNotFoundException e) {
							System.out.println("IMAGE NOT FOUND");
							System.exit(0);
						}
					}
					
				});
				
			ImageView enemy2 = new ImageView(enemyView);
				enemy2.setOnMouseClicked(new EventHandler <MouseEvent>(){
					
					@Override
					public void handle(MouseEvent click) {
						try {
							Scene arena = arena();
							gameplay.setScene(arena);
							
						} catch (FileNotFoundException e) {
							System.out.println("IMAGE NOT FOUND");
							System.exit(0);
						}
					}
					
				});
				
			ImageView enemy3 = new ImageView(enemyView);
				enemy3.setOnMouseClicked(new EventHandler <MouseEvent>(){
					
					@Override
					public void handle(MouseEvent click) {
						try {
							Scene arena = arena();
							gameplay.setScene(arena);
							
						} catch (FileNotFoundException e) {
							System.out.println("IMAGE NOT FOUND");
							System.exit(0);
						}
					}
					
				});
				
			ImageView boss = new ImageView(enemyView);
				boss.setOnMouseClicked(new EventHandler <MouseEvent>(){
					
					@Override
					public void handle(MouseEvent click) {
						try {
							Scene arena = arena();
							gameplay.setScene(arena);
							
						} catch (FileNotFoundException e) {
							System.out.println("IMAGE NOT FOUND");
							System.exit(0);
						}
					}
					
				});
				boss.setPreserveRatio(true);
				boss.setFitHeight(250);
				boss.setFitWidth(250);

		Image bonfireView = new Image(new FileInputStream("FinalProject/assets/scenes/fireIcon.png"));
			ImageView bonfireIcon = new ImageView(bonfireView);
			bonfireIcon.setOnMouseClicked(new EventHandler <MouseEvent>(){
				
				@Override
				public void handle(MouseEvent click) {
					try {
						Scene bonfire = bonfire();
						gameplay.setScene(bonfire);
						
					} catch (FileNotFoundException e) {
						System.out.println("IMAGE NOT FOUND");
						System.exit(0);
					}
				}
				
			});
			
		Image arrowView = new Image(new FileInputStream("FinalProject/assets/scenes/arrowMap.png"));
			ImageView arrow  = new ImageView(arrowView);
			ImageView arrow1 = new ImageView(arrowView);
			ImageView arrow2 = new ImageView(arrowView);
			ImageView arrow3 = new ImageView(arrowView);
			ImageView arrow4 = new ImageView(arrowView);
		
		HBox iconLayer = new HBox();
			iconLayer.getChildren().add(enemy1);
			iconLayer.getChildren().add(arrow);
			iconLayer.getChildren().add(enemy2);
			iconLayer.getChildren().add(arrow1);
			iconLayer.getChildren().add(miniboss);
			iconLayer.getChildren().add(arrow2);
			iconLayer.getChildren().add(bonfireIcon);
			iconLayer.getChildren().add(arrow3);
			iconLayer.getChildren().add(enemy3);
			iconLayer.getChildren().add(arrow4);
			iconLayer.getChildren().add(boss);
			iconLayer.setAlignment(Pos.CENTER);
			
	
		StackPane mapBackground = new StackPane();
			mapBackground.getChildren().add(paper);
			mapBackground.getChildren().add(iconLayer);
			mapBackground.setAlignment(Pos.CENTER);
	
			
		Scene mapScene = new Scene(mapBackground, 1920, 1080);
		return mapScene;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////             ARENA            /////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	
	public Scene arena() throws FileNotFoundException{
		
		Image arenaSplashView = new Image(new FileInputStream("FinalProject/assets/scenes/combat.png"));
        ImageView arenaSplash = new ImageView(arenaSplashView);
        
    Image ironCladView = new Image(new FileInputStream("FinalProject/assets/characters/ironClad.png"));
        ImageView ironClad = new ImageView(ironCladView);
        
    Image endTurnView = new Image(new FileInputStream("FinalProject/assets/scenes/endTurn.png"));
        ImageView endTurn = new ImageView(endTurnView);
    
    
    Pane endButton = new Pane();
        endButton.getChildren().add(endTurn);
    
    StackPane arenaBackground = new StackPane();
        arenaBackground.getChildren().add(arenaSplash);
        arenaBackground.getChildren().add(ironClad);
        arenaBackground.getChildren().add(endButton);

    
    Scene arena = new Scene(arenaBackground, 1920, 1080);
    return arena;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////              MAIN            /////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) {
		launch(args);
	}
}