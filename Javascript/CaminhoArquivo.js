
class CaminhoArquivo{

    diretorio;
    arquivo;

    constructor(dir, arq){
        this.diretorio = dir;
        this.arquivo = arq;
    }

    static isInt(val){
        return Number.isInteger(val);
    }

    static getInstance(id){
        if(CaminhoArquivo.isInt(id)){
            var dir = "/tmp/";
            var i = Math.trunc(id/1000);
            if(id > (i*1000)){
                i++;
            }
            dir = dir + i;
            var arq = dir + '/' + id;
            return new CaminhoArquivo(dir,arq);
        } else{
            return new CaminhoArquivo(null,null);
        }
    }

}

module.exports = CaminhoArquivo;