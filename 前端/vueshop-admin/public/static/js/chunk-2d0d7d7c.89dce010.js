(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-2d0d7d7c"],{7915:function(t,e,a){"use strict";a.r(e);var r=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.orders,border:!1},on:{"selection-change":t.handleSelectionChange}},[t._v(" // 表头 "),a("el-table-column",{attrs:{prop:"orderId",label:"订单编号",width:"180",align:"center"}}),a("el-table-column",{staticStyle:{"background-color":"#99a9bf"},attrs:{prop:"userId",label:"用户id",width:"180",align:"center"}}),a("el-table-column",{staticStyle:{"background-color":"#99a9bf"},attrs:{prop:"productId",label:"商品ID",width:"180",align:"center"}}),a("el-table-column",{staticStyle:{"background-color":"#99a9bf"},attrs:{prop:"productNum",label:"采购数量",width:"180",align:"center"}}),a("el-table-column",{staticStyle:{"background-color":"#99a9bf"},attrs:{prop:"productPrice",label:"售卖价格",width:"370",align:"center"}}),a("el-table-column",{staticStyle:{"background-color":"#99a9bf"},attrs:{prop:"orderTime",label:"下单时间",width:"620",align:"center"}})],1)],1)},l=[],n=a("bc3a"),o=a.n(n),c={data:function(){return{orders:[],status:!1,handle:!1}},watch:{status:function(t){!0===t&&(this.handle=!0)}},mounted:function(){this.getOrder()},methods:{getOrder:function(){var t=this;o.a.get("/api/order/getorder").then((function(e){t.orders=e.data.data}))}}},d=c,i=a("2877"),s=Object(i["a"])(d,r,l,!1,null,"2819dbf2",null);e["default"]=s.exports}}]);