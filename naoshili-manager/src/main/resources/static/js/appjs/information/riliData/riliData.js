var prefix = "/information/riliData"

$(function () {

   load();
});

function load() {
   $('#exampleTable1')
      .bootstrapTable(
         {
            method: 'get', // 服务器数据的请求方式 get or post
            url: prefix + "/list", // 服务器数据的加载地址
            //	showRefresh : true,
            //	showToggle : true,
            //	showColumns : true,
            iconSize: 'outline',
            toolbar: '#exampleToolbar',
            striped: true, // 设置为true会有隔行变色效果
            dataType: "json", // 服务器返回的数据类型
            pagination: true, // 设置为true会在底部显示分页条
            // queryParamsType : "limit",
            // //设置为limit则会发送符合RESTFull格式的参数
            singleSelect: false, // 设置为true将禁止多选
            // contentType : "application/x-www-form-urlencoded",
            // //发送到服务器的数据编码类型
            pageSize: 10, // 如果设置了分页，每页数据条数
            pageNumber: 1, // 如果设置了分布，首页页码
            //search : true, // 是否显示搜索框
            showColumns: false, // 是否显示内容下拉框（选择显示的列）
            sidePagination: "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
            queryParams: function (params) {
               return {
                  //说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
                  limit: params.limit,
                  offset: params.offset,
                  dataId: $('#id').val(),
                  experimentalMode: $('#experimentalMode1').val(),
                  type: $('#type2').val()
                  // name:$('#searchName').val(),
                  // username:$('#searchName').val()
               };
            },
            // //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
            // queryParamsType = 'limit' ,返回参数必须包含
            // limit, offset, search, sort, order 否则, 需要包含:
            // pageSize, pageNumber, searchText, sortName,
            // sortOrder.
            // 返回false将会终止请求
            columns: [
               /*{
                  checkbox : true
               },
                  */      /*					{
									field : 'id', 
									title : 'id' 
								},*/
               /* {
                   field: 'dataId',
                   title: '实验序号'
                },*/
               {
                  field: 'time',
                  title: '采集时间'
               },
               /*
                                               {
                          field : 'synchronizationMark',
                          title : '同步标记'
                       },
                          */
               /* {
                   field: 'experimentalMode',
                   title: '实验类型',
                   formatter: function (value) {
                      if (value == 1) {
                         return "多段移动视标试验"
                      } else if (value == 2) {
                         return "单段移动视标试验"
                      } else if (value == 3) {
                         return "闪烁视标试验"
                      }
                   }
                }, */{
                  field: 'externalTriggerMark',
                  title: '外部触发标记'
               },
               {
                  field: 'type',
                  title: '类型'
               },

               {
                  field: 'ch1',
                  title: 'CH1'
               },
               {
                  field: 'ch2',
                  title: 'CH2'
               },
               {
                  field: 'ch3',
                  title: 'CH3'
               },
               {
                  field: 'ch4',
                  title: 'CH4'
               },
               {
                  field: 'ch5',
                  title: 'CH5'
               },
               {
                  field: 'ch6',
                  title: 'CH6'
               },
               {
                  field: 'ch7',
                  title: 'CH7'
               },
               {
                  field: 'ch8',
                  title: 'CH8'
               },
               {
                  field: 'ch9',
                  title: 'CH9'
               },
               {
                  field: 'ch10',
                  title: 'CH10'
               },
               {
                  field: 'ch11',
                  title: 'CH11'
               },
               {
                  field: 'ch12',
                  title: 'CH12'
               },
               {
                  field: 'ch13',
                  title: 'CH13'
               },
               {
                  field: 'ch14',
                  title: 'CH14'
               },
               {
                  field: 'ch15',
                  title: 'CH15'
               },
               {
                  field: 'ch16',
                  title: 'CH16'
               },
               {
                  field: 'ch17',
                  title: 'CH17'
               },
               {
                  field: 'ch18',
                  title: 'CH18'
               },
               {
                  field: 'ch19',
                  title: 'CH19'
               },
               {
                  field: 'ch20',
                  title: 'CH20'
               },
               {
                  field: 'ch21',
                  title: 'CH21'
               },
               {
                  field: 'ch22',
                  title: 'CH22'
               }/*,
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm '+s_edit_h+'" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm '+s_remove_h+'" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="备用"  mce_href="#" onclick="resetPwd(\''
												+ row.id
												+ '\')"><i class="fa fa-key"></i></a> ';
										return e + d ;
									}
								}*/]
         });
}


function reLoad() {
   $('#exampleTable1').bootstrapTable('refresh');
}

function reLoadOx(id) {

   if (id == 1) {
      $('#type2').val('oxy');
      loadChart('oxy')
      reLoad();
   } else if (id == 2) {
      $('#type2').val('deoxy');
      loadChart('deoxy')
      reLoad();
   }

}

var id = $('#id').val()
var barChart = echarts.init(document.getElementById("main"));

var option = {
   title: {
      text: 'CH1-CH22通道全部数据'
   },
   tooltip: {
      trigger: 'axis'
   },
   grid: {
      top: '15%',//距上边距

      left: '15%',//距离左边距

      right: '15%',//距离右边距

      bottom: '15%',//距离下边距

   },
   legend: {

      data: ['全选', '全不选', 'CH1', 'CH2', 'CH3', 'CH4', 'CH5', 'CH6', 'CH7', 'CH8', 'CH9',
         'CH10', 'CH11', 'CH12', 'CH13', 'CH14', 'CH15', 'CH16', 'CH17', 'CH18', 'CH19',
         'CH20', 'CH21', 'CH22'],
      top: "6%"
   },
   xAxis: {
      name: '采集时间',
      type: 'category',
      boundaryGap: false,
      /*data: xoxy*/
   },
   yAxis: {
      type: 'value'
   },
   dataZoom: [{
      type: 'inside',
      start: 0,
      end: 100,
      filterMode: 'empty'
   }, {
      start: 0,
      end: 100,
      handleIcon: 'M10.7,11.9v-1.3H9.3v1.3c-4.9,0.3-8.8,4.4-8.8,9.4c0,5,3.9,9.1,8.8,9.4v1.3h1.3v-1.3c4.9-0.3,8.8-4.4,8.8-9.4C19.5,16.3,15.6,12.2,10.7,11.9z M13.3,24.4H6.7V23h6.6V24.4z M13.3,19.6H6.7v-1.4h6.6V19.6z',
      handleSize: '80%',
      handleStyle: {
         color: '#fff',
         shadowBlur: 3,
         shadowColor: 'rgba(0, 0, 0, 0.6)',
         shadowOffsetX: 2,
         shadowOffsetY: 2
      },
      filterMode: 'empty'
   }],
   series: [
      {
         type: 'line',
      },
      {
         type: 'line',

      },
      {
         type: 'line',
      },
      {
         type: 'line',
      },
      {
         /*name: 'CH4',*/
         type: 'line',
         /*data: ch4oxy*/
      },
      {
         /*name: 'CH5',*/
         type: 'line',
         /*data: ch5oxy*/
      }
      ,
      {
         /*name: 'CH6',*/
         type: 'line',
         /*data: ch6oxy*/
      }
      ,
      {
         /*name: 'CH7',*/
         type: 'line',
         /*data: ch7oxy*/
      }
      ,
      {
         /*name: 'CH8',*/
         type: 'line',
         /*data: ch8oxy*/
      }
      ,
      {
         /*name: 'CH9',*/
         type: 'line',
         /*data: ch9oxy*/
      }
      ,
      {
         /*name: 'CH10',*/
         type: 'line',
         /*data: ch10oxy*/
      }
      ,
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',

         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      },
      {
         /*name: 'CH11',*/
         type: 'line',
         /*data: ch11oxy*/
      }
   ]
}

barChart.setOption(option)
barChart.showLoading();
var selectArr = option.legend.data;
barChart.on('legendselectchanged', function (obj) {
   var selected = obj.selected;
   var name = obj.name;
// 使用 legendToggleSelect Action 会重新触发 legendselectchanged Event，导致本函数重复运行
// 使得 无 selected 对象
   if (name == '全选') {//需要配置一个legend为‘全选’的名称
//alert("33");
      var flag = $(this).attr('flag');
      if (flag == 1) {
         var val = false;
         $(this).attr('flag', 0);
         $(this).val('全选中');
      } else {
         var val = true;
         $(this).attr('flag', 1);
         $(this).val('全不选');
      }
      var obj = {};
      for (var key in selectArr) {
         obj[selectArr[key]] = val;
      }
      option.legend.selected = obj;

      barChart.setOption(option);
   }
});

function loadChart(type) {

   $.ajax({
      type: "get",
      async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
      url: "/information/riliData/getRili",    //请求发送到TestServlet处
      data: {id: id, type: type},
      dataType: "json",        //返回数据形式为json
      success: function (result) {
         var indexs = result.data.indexs;
         console.log(indexs, "索引数组")
         console.log(result)

         console.log(indexs[0]);
         var index = [];
         for (var i = 0; i < indexs.length; i++) {
            if (i == 0) {
               index.push(
                  [{
                     xAxis: result.data.xoxy[indexs[0]]
                  }, {
                     xAxis: result.data.xoxy[indexs[i + 1]]
                  }]
               );
            } else if (i % 2 == 0 && i > 1) {
               index.push(
                  [{
                     xAxis: result.data.xoxy[indexs[i]]
                  }, {
                     xAxis: result.data.xoxy[indexs[i + 1]]
                  }]
               );
            }
         }
         //请求成功时执行该函数内容，result即为服务器返回的json对象
         if (result) {

            barChart.hideLoading();    //隐藏加载动画
            barChart.setOption({        //加载数据图表
               xAxis: {
                  data: result.data.xoxy
               },
               series: [
                  {
                     name: '全选'

                  }, {
                     name: 'CH1',
                     data: result.data.ch1oxy,
                     markArea: {
                        data: index
                     },
                  },
                  {
                     name: 'CH2',
                     data: result.data.ch2oxy,

                  },
                  {
                     name: 'CH3',
                     data: result.data.ch3oxy
                  },
                  {
                     name: 'CH4',
                     data: result.data.ch4oxy
                  },
                  {
                     name: 'CH5',
                     data: result.data.ch5oxy
                  }
                  ,
                  {
                     name: 'CH6',
                     data: result.data.ch6oxy
                  }
                  ,
                  {
                     name: 'CH7',
                     data: result.data.ch7oxy
                  }
                  ,
                  {
                     name: 'CH8',
                     data: result.data.ch8oxy
                  }
                  ,
                  {
                     name: 'CH9',
                     data: result.data.ch9oxy
                  }
                  ,
                  {
                     name: 'CH10',
                     data: result.data.ch10oxy
                  }
                  ,
                  {
                     name: 'CH11',
                     data: result.data.ch11oxy
                  }, {
                     name: 'CH12',
                     data: result.data.ch12oxy
                  },
                  {
                     name: 'CH13',
                     data: result.data.ch13oxy
                  },
                  {
                     name: 'CH14',
                     data: result.data.ch14oxy
                  },
                  {
                     name: 'CH15',
                     data: result.data.ch15oxy
                  }
                  ,
                  {
                     name: 'CH16',
                     data: result.data.ch16oxy
                  }
                  ,
                  {
                     name: 'CH17',
                     data: result.data.ch17oxy
                  }
                  ,
                  {
                     name: 'CH18',
                     data: result.data.ch18oxy
                  }
                  ,
                  {
                     name: 'CH19',
                     data: result.data.ch19oxy
                  }
                  ,
                  {
                     name: 'CH20',
                     data: result.data.ch20oxy
                  }
                  ,
                  {
                     name: 'CH21',
                     data: result.data.ch21oxy
                  },
                  {
                     name: 'CH22',
                     data: result.data.ch22oxy
                  }]


            })
            setTimeout(() => {
               barChart.resize();
            }, 100)

            /*var opt = barChart.getOption();
            barChart.clear();

            barChart.resize({height: "700px", width: "1800px"});
            barChart.setOption(opt)*/
         }
      },
      error: function (errorMsg) {
         //请求失败时执行该函数
         alert("图表请求数据失败!");
         myChart.hideLoading();
      }
   })
}

loadChart('oxy');

function exportAll(id) {
   var dataId = $('#id').val();
   console.log(dataId, "dataid")
   window.location.href = "/information/riliData/export?id=" + id + "&dataId=" + dataId;
}

function add() {
   layer.open({
      type: 2,
      title: '增加',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: prefix + '/add' // iframe的url
   });
}

function edit(id) {
   layer.open({
      type: 2,
      title: '编辑',
      maxmin: true,
      shadeClose: false, // 点击遮罩关闭层
      area: ['800px', '520px'],
      content: prefix + '/edit/' + id // iframe的url
   });
}

function remove(id) {
   layer.confirm('确定要删除选中的记录？', {
      btn: ['确定', '取消']
   }, function () {
      $.ajax({
         url: prefix + "/remove",
         type: "post",
         data: {
            'id': id
         },
         success: function (r) {
            if (r.code == 0) {
               layer.msg(r.msg);
               reLoad();
            } else {
               layer.msg(r.msg);
            }
         }
      });
   })
}

function resetPwd(id) {
}

function batchRemove() {
   var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
   if (rows.length == 0) {
      layer.msg("请选择要删除的数据");
      return;
   }
   layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
      btn: ['确定', '取消']
      // 按钮
   }, function () {
      var ids = new Array();
      // 遍历所有选择的行数据，取每条数据对应的ID
      $.each(rows, function (i, row) {
         ids[i] = row['id'];
      });
      $.ajax({
         type: 'POST',
         data: {
            "ids": ids
         },
         url: prefix + '/batchRemove',
         success: function (r) {
            if (r.code == 0) {
               layer.msg(r.msg);
               reLoad();
            } else {
               layer.msg(r.msg);
            }
         }
      });
   }, function () {

   });
}