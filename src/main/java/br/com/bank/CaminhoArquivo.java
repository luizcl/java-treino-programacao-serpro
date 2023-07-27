package br.com.bank;

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
        /*
        if (id <= 1000) {
            d = b + id;
        } else {
            int i = id;
            boolean f = true;
            while (f) {
                if (id <= (i * 1000)) {
                    d = b + i;
                    f = false;
                }
                i++;
            }
        }
        */
        if(id != null){
            int i = id/1000;
            if(id <= (i * 1000)){
                d = b + i;
            }
            else{
                i++;
                d = b + i;
            }
            String arquivo = d + '/' + id.toString();
            return new CaminhoArquivo(Paths.get(d), Paths.get(arquivo));
        }else{
            return new CaminhoArquivo(null, null);
        }

    }

}
