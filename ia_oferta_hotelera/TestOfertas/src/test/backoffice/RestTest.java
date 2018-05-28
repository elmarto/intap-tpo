package test.backoffice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class RestTest {

    public static void main(String[] args) {
        try {
            rest();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void rest() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);

        URL url = new URL("http://192.168.0.107:8080/TPO_BO_WEB/rest/ServiciosBO/RegistrarLog");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Content-Type", "application/json");

        Log logueo = new Log("PW", "BO", "Alta Oferta Hotel", "SUCCESS");
        // Para IOUtils hace falta commons-io-2.4.jar (de apache), está en wildfly
        IOUtils.write(mapper.writeValueAsString(logueo), urlConnection.getOutputStream());
        String response = IOUtils.toString(urlConnection.getInputStream());

        System.out.println("Respuesta: " + response);
    }

}
