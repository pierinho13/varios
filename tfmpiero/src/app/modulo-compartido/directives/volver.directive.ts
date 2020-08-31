import { Directive, ElementRef, HostListener, Input, OnInit, OnChanges, SimpleChanges } from '@angular/core';
import { Router } from '@angular/router';

@Directive({ 
    selector: '[appVolver]' 
})

export class VolverDirective implements OnInit {

    @Input('appVolver') urlAVolver?:string;
   
    
    constructor(private el: ElementRef, private router: Router) {}   

    ngOnInit() {
    }

    @HostListener('click') onMouseEnter() {

        if(this.urlAVolver) {
            this.router.navigate( [ this.urlAVolver ] );
        } else {
            if(history) { // nunca deberia ser indefinido
                history.back();
            }
        }
    }
      
}