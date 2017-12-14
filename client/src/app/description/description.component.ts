import {Component, OnDestroy, OnInit} from '@angular/core';
import {SharedService} from "../service/shared/shared.service";
import {Subscription} from "rxjs/Subscription";
import {Archive} from "../data/archive";

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css']
})

export class DescriptionComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription;
  archive: Archive;

  constructor(private shared: SharedService) {

  }

  ngOnInit() {
    this.archive = this.shared.getCurrent();
  }

  ngOnDestroy() {
  }
}
