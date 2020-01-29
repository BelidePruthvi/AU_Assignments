import { Pipe, PipeTransform } from '@angular/core';

@Pipe({name: 'initialCapital'})
export class InitialCapital implements PipeTransform {
  transform(value: string): string {
    value=value[0].toUpperCase() +  value.slice(1);
    return value; 
  }
}
