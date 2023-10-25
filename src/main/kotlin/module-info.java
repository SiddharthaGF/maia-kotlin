module com.maia.maiakotlin {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;
    requires kotlinx.coroutines.core.jvm;


    opens com.maia.maiakotlin to javafx.fxml;
    exports com.maia.maiakotlin;
}