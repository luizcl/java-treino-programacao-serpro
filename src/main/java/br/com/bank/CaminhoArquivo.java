package br.com.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {


    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {
        String b = "/tmp/";
        String d = null;
        if(id != null){
            BigDecimal i = new BigDecimal(id);
            BigDecimal resultado = i.divide(new BigDecimal(1000), 0, RoundingMode.UP);
            d = b + resultado.intValue();
            String arquivo = d + '/' + id.toString();
            return new CaminhoArquivo(Paths.get(d), Paths.get(arquivo));
        }else{
            return null;
        }

    }

    public static CaminhoArquivo getInstance2(Integer id) {
        String b = "/tmp/";
        String d = null;
        if (id != null)
        {
            double id_double = id;
            int i = (int) Math.ceil(id_double/1000); // Arredonda pra cima
            d = b + i;
            String arquivo = d + '/' + id.toString();
            return new CaminhoArquivo(Paths.get(d), Paths.get(arquivo));
        }

        return null;

    }

    public static CaminhoArquivo getInstance3(Integer id) {
    String b = "/tmp/";
    String d = null;
    if(id != null){
        int i = id/1000;
        if(id > (i * 1000)){
            i++;
        }
        d = b + i;
        String arquivo = d + '/' + id.toString();
        return new CaminhoArquivo(Paths.get(d), Paths.get(arquivo));
    }else{
        return null;
    }

    }

}
