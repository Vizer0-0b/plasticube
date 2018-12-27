<!-- jQuery -->
<script src="vendors/jquery/dist/jquery.min.js"></script>

<div class="right_col" role="main">
  <div class="">
    <div class="page-title">
      <div class="title_left">
        <h3>Repository Manager |<small>StatTrak™</small></h3>
      </div>
    </div>

    <div class="clearfix"></div>

    <div class="row">
      <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="x_panel">
          <div class="x_title">
            <h2>Main List <small>and Detail</small></h2>
            <ul class="nav navbar-right panel_toolbox">
              <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
              </li>
            </ul>
            <div class="clearfix"></div>
          </div>
          <div class="x_content">
            <table id="datatable" class="table table-striped table-bordered">
            
              <thead>
                <tr>
                  <th>id</th>
                  <th>name</th>
                  <th>code</th>
                  <th>remainNum</th>
                  <th>--IN--</th>
                  <th>--OUT--</th>
                  <th>--EDIT--</th>
                  <th><input name="goods_insert" type="button" class="btn btn-success btn-xs goodsInsert" value="goods_insert"/></th>
                </tr>
              </thead>

              <tbody>
                <#list  goodsList as goods> 
                  <tr id="${goods.id}">
                    <td id="gid" align="center">${goods.id}</td>
                    <td id="gname" align="center">${goods.name}</td>  
                    <td id="gcode" align="center">${goods.code}</td>  
                    <td id="gremainNum" align="right">${goods.remainNum}</td>
                    <td><input name="goods_in"  type="button" class="btn btn-primary btn-xs goodsIn" value="goods_in"/></td>
                    <td><input name="goods_out" type="button" class="btn btn-success btn-xs goodsOut" value="goods_out"/></td>
                    <td><input name="goods_edit" type="button" class="btn btn-warning btn-xs goodsEdit" value="goods_edit"/></td>
                    <td><button name="goods_delete" type="submit" class="btn btn-danger btn-xs goodsDelete">goods_delete</button></td>
                    
                  </tr>
                </#list>
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>


<#include "goodsEdit.ftl">
<#include "goodsIn.ftl">
<#include "goodsOut.ftl">
<#include "goodsInsert.ftl">

<script type="text/javascript"> 
$(document).ready(function(){
  // delete button down
  $(".goodsDelete").click(function(event){
    var deleteData= {
        "id": $(event.target).parent().parent().children("td#gid").html(),
        _method : 'delete'};
    $.ajax({
      async : false,
      type : "POST",
      url : '/goodsdelete',
      dataType : "json",
      data : deleteData,
      error : function() {
        alert("oprating failed! Your value mabe invalid");
      },
      success : function(data) {
        alert(data.msg);
      }
    });
    window.location.reload();
  });
}); 
</script> 