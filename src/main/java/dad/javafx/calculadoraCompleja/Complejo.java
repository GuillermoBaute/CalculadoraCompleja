package dad.javafx.calculadoraCompleja;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Complejo extends Application{

	private DoubleProperty real = new SimpleDoubleProperty(0);
	private DoubleProperty imaginario = new SimpleDoubleProperty(0);
	private TextField tf1, tf2, tf3, tf4, tf5, tf6;
	
	public Complejo() {}
	
	public Complejo(double real, double imaginario) {
		super();
		setReal(real);
		setImaginario(imaginario);
	}

	public DoubleProperty realProperty() {
		return this.real;
	}
	

	public double getReal() {
		return this.realProperty().get();
	}
	

	public void setReal(final double real) {
		this.realProperty().set(real);
	}
	

	public DoubleProperty imaginarioProperty() {
		return this.imaginario;
	}
	

	public double getImaginario() {
		return this.imaginarioProperty().get();
	}
	

	public void setImaginario(final double imaginario) {
		this.imaginarioProperty().set(imaginario);
	}

	@Override
	public String toString() {
		return getReal() + "+" + getImaginario() + "i";
	}
	
	public Complejo add(Complejo c) {
		Complejo r = new Complejo();
		r.realProperty().bind(realProperty().add(c.realProperty()));
		r.imaginarioProperty().bind(imaginario.add(c.imaginarioProperty()));
	return r;	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Label simbolo = new Label("+");
		Label i = new Label("i");
		
		
		
		HBox caja1 = new HBox();
		caja1.setSpacing(5);
		caja1.setAlignment(Pos.CENTER);
		caja1.getChildren().addAll(tf1, simbolo, tf2, i);
		
		HBox caja2 = new HBox();
		caja2.setSpacing(5);
		caja2.setAlignment(Pos.CENTER);
		caja2.getChildren().addAll(tf3, simbolo, tf4, i);
		
		Separator separador = new Separator();
		
		HBox caja3 = new HBox();
		caja3.setSpacing(5);
		caja3.setAlignment(Pos.CENTER);
		caja3.getChildren().addAll(tf5, simbolo, tf6, i);
		
		VBox conjunto2 = new VBox();
		conjunto2.setSpacing(5);
		conjunto2.setAlignment(Pos.CENTER);
		conjunto2.getChildren().addAll(caja1, caja2, separador, caja3);
		
		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
