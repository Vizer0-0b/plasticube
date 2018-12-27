<!-- Large modal -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" id="goodsInsert" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg" role="document">
    <div class="modal-content">
      <div class="clearfix"></div>
      <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
          <div class="x_panel">
            <div class="x_title">
              <h2>Goods Insert <small>You can create a new kinds of goods into repository here</small></h2>
              <ul class="nav navbar-right panel_toolbox">
                <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                </li>
              </ul>
              <div class="clearfix"></div>
            </div>
            <div class="x_content">
              <br />
              <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left" action="" method="">
                <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">name <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="name" name="name" required="required" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>
                <div class="form-group">
                  <label for="code" class="control-label col-md-3 col-sm-3 col-xs-12">code <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                    <input type="text" id="code" name="code" required="required" class="form-control col-md-7 col-xs-12">
                  </div>
                </div>
                <div class="ln_solid"></div>
                <div class="form-group">
                  <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-8">
                    <button type="submit" class="btn btn-success">Submit</button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript"> 
$(document).ready(function(){
  //temp event
  var e;

  // goodsInsert Modal
  $(".goodsInsert").click(function(event){
    $("#goodsInsert").modal("show");
    e = event;
  });
  $("#goodsInsert").on("shown.bs.modal", function () {
  });
  $("#goodsInsert").on("hidden.bs.modal", function () {
    $("#goodsInsert").find("#name").val("");
    $("#goodsInsert").find("#code").val("");
  });

  $("#goodsInsert").find(":submit").click(function(){
    var postData= {
        "code": $("#goodsInsert").find("#code").val(),
        "name": $("#goodsInsert").find("#name").val()};
    $.ajax({
      async : false,
      type : "POST",
      url : '/goodsinsert',
      dataType : "json",
      data : postData,
      error : function() {
        alert("oprating failed! Your value mabe invalid");
      },
      success : function(data) {
        alert(data.msg);
      }
    });
    $("#goodsInsert").modal("hide");
  });
}); 
</script> 