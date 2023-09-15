package app;

import static spark.Spark.*;
import service.VeiculoService;


public class Aplicacao {
	
	private static VeiculoService veiculoService = new VeiculoService();
	
    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");
        
        post("/veiculo/insert", (request, response) -> veiculoService.insert(request, response));

        get("/veiculo/:id", (request, response) -> veiculoService.get(request, response));
        
        get("/veiculo/list/:orderby", (request, response) -> veiculoService.getAll(request, response));

        get("/veiculo/update/:id", (request, response) -> veiculoService.getToUpdate(request, response));
        
        post("/veiculo/update/:id", (request, response) -> veiculoService.update(request, response));
           
        get("/veiculo/delete/:id", (request, response) -> veiculoService.delete(request, response));

             
    }
}