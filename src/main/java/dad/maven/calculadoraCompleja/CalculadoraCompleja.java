package dad.maven.calculadoraCompleja;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CalculadoraCompleja extends Application {

	private DoubleProperty real = new SimpleDoubleProperty(0);
	private DoubleProperty imaginario = new SimpleDoubleProperty(0);
	private TextField tf1, tf2, tf3, tf4, tf5, tf6;
	private Button btIgual;
	private ComboBox<String> combo1;

	public CalculadoraCompleja() {
	}

	public CalculadoraCompleja(double real, double imaginario) {
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

	public CalculadoraCompleja add(CalculadoraCompleja c) {
		CalculadoraCompleja r = new CalculadoraCompleja();
		r.realProperty().bind(realProperty().add(c.realProperty()));
		r.imaginarioProperty().bind(imaginario.add(c.imaginarioProperty()));
		return r;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// CBOX CONJUNTO1
		combo1 = new ComboBox<String>();
		combo1.getItems().addAll("+", "-", "*", "/");
		combo1.getSelectionModel().selectFirst();

		VBox conjunto1 = new VBox();
		conjunto1.setSpacing(5);
		conjunto1.setAlignment(Pos.CENTER_LEFT);
		conjunto1.getChildren().addAll(combo1);

		// CBOX DEL CONJUNTO2
		tf1 = new TextField("0");
		tf1.setPrefColumnCount(2);
		tf1.setMaxWidth(100);
		tf1.setAlignment(Pos.CENTER);

		tf2 = new TextField("0");
		tf2.setPrefColumnCount(2);
		tf2.setMaxWidth(100);
		tf2.setAlignment(Pos.CENTER);

		tf3 = new TextField("0");
		tf3.setPrefColumnCount(2);
		tf3.setMaxWidth(100);
		tf3.setAlignment(Pos.CENTER);

		tf4 = new TextField("0");
		tf4.setPrefColumnCount(2);
		tf4.setMaxWidth(100);
		tf4.setAlignment(Pos.CENTER);

		tf5 = new TextField("0");
		tf5.setPrefColumnCount(2);
		tf5.setMaxWidth(100);
		tf5.setAlignment(Pos.CENTER);
		tf5.setDisable(true);

		tf6 = new TextField("0");
		tf6.setPrefColumnCount(2);
		tf6.setMaxWidth(100);
		tf6.setAlignment(Pos.CENTER);
		tf6.setDisable(true);

		HBox caja1 = new HBox();
		caja1.setSpacing(5);
		caja1.setAlignment(Pos.CENTER);
		caja1.getChildren().addAll(tf1, new Label("+"), tf2, new Label("i"));

		HBox caja2 = new HBox();
		caja2.setSpacing(5);
		caja2.setAlignment(Pos.CENTER);
		caja2.getChildren().addAll(tf3, new Label("+"), tf4, new Label("i"));

		Separator separador = new Separator();

		HBox caja3 = new HBox();
		caja3.setSpacing(5);
		caja3.setAlignment(Pos.CENTER);
		caja3.getChildren().addAll(tf5, new Label("+"), tf6, new Label("i"));

		VBox conjunto2 = new VBox();
		conjunto2.setSpacing(5);
		conjunto2.setAlignment(Pos.CENTER);
		conjunto2.getChildren().addAll(caja1, caja2, separador, caja3);

		// CBOX CONJUNTO3
		btIgual = new Button("=");

		VBox conjunto3 = new VBox();
		conjunto3.setSpacing(5);
		conjunto3.setAlignment(Pos.CENTER_RIGHT);
		conjunto3.getChildren().addAll(btIgual);

		HBox root = new HBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(conjunto1, conjunto2, conjunto3);

		Scene escena = new Scene(root, 320, 200);

		primaryStage.setScene(escena);
		primaryStage.setTitle("CalculadoraCompleja");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
