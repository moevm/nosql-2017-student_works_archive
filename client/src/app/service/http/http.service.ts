import {Injectable} from '@angular/core';
import {Archive} from "../../data/archive";
import {Headers, Http, Response} from '@angular/http';
import {Observable} from "rxjs/Observable";

@Injectable()
export class HttpService {

  constructor(private http: Http) {
  }


  getData(url: string, params: string) {
    return this.http.get(url, {params});
  }

  postBody(params: string, url: string) {
    let headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post(url, params, {headers: headers})
     // .catch((error: any) => Observable.throw(error));
  }
}
