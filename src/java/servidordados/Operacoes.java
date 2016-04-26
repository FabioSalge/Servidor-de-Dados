package servidordados;

import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author 1142412
 */
@Singleton
@Path("operacoes")
public class Operacoes {

    @Context
    private UriInfo context;
    int contas[] = {1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};

    /**
     * Creates a new instance of Operacoes
     */
    public Operacoes() {
    }

    /**
     * Retrieves representation of an instance of servidordados.Operacoes
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("text/plain")
    @Path("/saldo/{idConta}")
    public String getSaldo(@PathParam("idConta") String conta_) {
        int conta = Integer.parseInt(conta_);
        System.out.println("Servidor de Dados - Enviado saldo da conta " + conta + " com o valor de " + contas[conta]);
        return Integer.toString(contas[conta]);
    }

    /**
     * PUT method for updating or creating an instance of Operacoes
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @GET
    @Produces("text/plain")
    @Path("/setsaldo/{idConta}/{valor}")
    public void setSaldo(@PathParam("idConta") String conta_, @PathParam("valor") String valor_) {
        System.out.println("Servidor de Dados - entrou no setSaldo");
        int conta = Integer.parseInt(conta_);
        int valor = Integer.parseInt(valor_);
        contas[conta] = valor;
        System.out.println("Servidor de Dados - Alterado saldo da conta " + conta + " para o valor de " + contas[conta]);
    }
}
