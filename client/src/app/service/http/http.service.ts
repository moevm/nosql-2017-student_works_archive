import {Injectable} from '@angular/core';
import {Http} from '@angular/http';

@Injectable()
export class HttpService {

  constructor(private http: Http) {
  }


  getData(url: string, params: string) {
    return this.http.get(url, {params});
  }
}
