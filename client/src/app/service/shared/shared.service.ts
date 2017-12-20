import {Injectable} from '@angular/core';
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {Archive} from "../../data/archive";
import {Observable} from "rxjs/Observable";
import {Subject} from "rxjs/Subject";

@Injectable()
export class SharedService {
  private current = new Subject<any>();
  archive: Archive;
  archiveState$ = this.current.asObservable();

  constructor() {
  }



  setCurrent(arch: Archive) {
    this.archive = arch;
  }

  getCurrent() {
    return this.archive;
  }

  emitChange(change: any) {
    this.current.next(change);
  }
}
