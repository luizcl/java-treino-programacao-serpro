const CaminhoArquivo = require('./CaminhoArquivo');

test('Teste CaminhoArquivo', () => {
    const ca = CaminhoArquivo.getInstance(1);
    const expectedDiretorio = '/tmp/1';
    const expectedArquivo = '/tmp/1/1';
    expect(ca.diretorio).toBe(expectedDiretorio);
    expect(ca.arquivo).toBe(expectedArquivo);
});

test('Teste CaminhoArquivo', () => {
    const ca = CaminhoArquivo.getInstance(2);
    const expectedDiretorio = '/tmp/1';
    const expectedArquivo = '/tmp/1/2';
    expect(ca.diretorio).toBe(expectedDiretorio);
    expect(ca.arquivo).toBe(expectedArquivo);
});

test('Teste CaminhoArquivo', () => {
    const ca = CaminhoArquivo.getInstance(1000);
    const expectedDiretorio = '/tmp/1';
    const expectedArquivo = '/tmp/1/1000';
    expect(ca.diretorio).toBe(expectedDiretorio);
    expect(ca.arquivo).toBe(expectedArquivo);
});

test('Teste CaminhoArquivo', () => {
    const ca = CaminhoArquivo.getInstance(1500);
    const expectedDiretorio = '/tmp/2';
    const expectedArquivo = '/tmp/2/1500';
    expect(ca.diretorio).toBe(expectedDiretorio);
    expect(ca.arquivo).toBe(expectedArquivo);
});

test('Teste CaminhoArquivo', () => {
    const ca = CaminhoArquivo.getInstance(2000);
    const expectedDiretorio = '/tmp/2';
    const expectedArquivo = '/tmp/2/2000';
    expect(ca.diretorio).toBe(expectedDiretorio);
    expect(ca.arquivo).toBe(expectedArquivo);
});

test('Teste CaminhoArquivo', () => {
    const ca = CaminhoArquivo.getInstance(2001);
    const expectedDiretorio = '/tmp/3';
    const expectedArquivo = '/tmp/3/2001';
    expect(ca.diretorio).toBe(expectedDiretorio);
    expect(ca.arquivo).toBe(expectedArquivo);
});

test('Teste CaminhoArquivo', () => {
    const ca = CaminhoArquivo.getInstance(null);
    const expectedDiretorio = null;
    const expectedArquivo = null;
    expect(ca.diretorio).toBe(expectedDiretorio);
    expect(ca.arquivo).toBe(expectedArquivo);
});