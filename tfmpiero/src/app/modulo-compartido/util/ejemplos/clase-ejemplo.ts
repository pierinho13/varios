
class Documento {

    titulo:string;
    contenido:string;

    constructor (titulo, contenido) {
      this.titulo = titulo;
      this.contenido = contenido;
    }

    // Método
    obtieneDocumento () {
      return this.titulo + ' ' + this.contenido;
    }

    declaraciones() {

        const inmodificable = 2;
        let modificable = 2;

        inmodificable = inmodificable + 2;

        modificable = modificable + 2;
    }
  }



