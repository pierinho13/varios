
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

        modificable = modificable + 2;

        inmodificable = inmodificable + 2;
    }

    ejemploOperadores() {

        const array = [10,5,20,3,4,5];

        let arraySoloPares = array.filter(n=> n % 2 == 0);

    }
  }



