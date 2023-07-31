package br.com.bank;

import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


class CaminhoArquivoTest {

    @Test
    //@Disabled
    public void deve_montar_caminho_para_arquivo() {
        
        CaminhoArquivo caminhoArquivo = CaminhoArquivo.getInstance(1);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/2"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1000);
        assertEquals(Paths.get("/tmp/1"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/1/1000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(1500);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/1500"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2000);
        assertEquals(Paths.get("/tmp/2"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/2/2000"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(2001);
        assertEquals(Paths.get("/tmp/3"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/3/2001"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(4001);
        assertEquals(Paths.get("/tmp/5"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/5/4001"), caminhoArquivo.getArquivo());

        caminhoArquivo = CaminhoArquivo.getInstance(null);
        assertNull(caminhoArquivo);

        caminhoArquivo = CaminhoArquivo.getInstance(0);
        assertEquals(Paths.get("/tmp/0"), caminhoArquivo.getDiretorio());
        assertEquals(Paths.get("/tmp/0/0"), caminhoArquivo.getArquivo());
        
    }

}