import {Component, OnDestroy, OnInit} from '@angular/core';
import {SharedService} from "../service/shared/shared.service";
import {Subscription} from "rxjs/Subscription";
import {Archive} from "../data/archive";
import {HttpService} from "../service/http/http.service";

@Component({
  selector: 'app-description',
  templateUrl: './description.component.html',
  styleUrls: ['./description.component.css'],
  providers: [HttpService]
})

export class DescriptionComponent implements OnInit, OnDestroy {

  private subscriptions: Subscription;
  archive: Archive;
  url = 'http://localhost:8090/api/files/get';

  constructor(private shared: SharedService,
              private httpService: HttpService) {
  }

  ngOnInit() {
    this.archive = this.shared.getCurrent();
  }

  ngOnDestroy() {
  }

  getText() {
    const param = new URLSearchParams();
    param.set("file", this.archive.file.toString());
    this.httpService.getText(this.url, param.toString())
      .subscribe(data => {
        console.log(data);
        var blob = new Blob([data.blob()], { type: 'application/msword'});
        var url= window.URL.createObjectURL(blob);
        window.open(url);
        console.log();
      });
  }


}
