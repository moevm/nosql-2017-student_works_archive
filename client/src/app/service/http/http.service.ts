import {Injectable} from '@angular/core';
import {Archive} from '../../data/archive';
import {Headers, Http, Response, ResponseContentType} from '@angular/http';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class HttpService {

  constructor(private http: Http) {
  }


  getData(url: string, params: string) {
    return this.http.get(url, {params});
  }

  postBody(params: any, url: string) {
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post(url,  params)
      .map(resp => resp.json() as Archive[]);
    // .catch((error: any) => Observable.throw(error));
  }

  postStat(params: any, url: string) {
    const headers = new Headers({'Content-Type': 'application/json'});
    return this.http.post(url,  params)
    // .catch((error: any) => Observable.throw(error));
  }

  getText(url: string,params: string){
    return this.http.get(url,{params, responseType: ResponseContentType.Blob});
  }
}
