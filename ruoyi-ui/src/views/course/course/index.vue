<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="课程编号" prop="courCode">
        <el-input
          v-model="queryParams.courCode"
          placeholder="请输入课程编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预估学生人数" prop="courEsti">
        <el-input
          v-model="queryParams.courEsti"
          placeholder="请输入预估学生人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="目前学生人数" prop="courCurrent">
        <el-input
          v-model="queryParams.courCurrent"
          placeholder="请输入目前学生人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="可用改分时间" prop="courAvhours">
        <el-input
          v-model="queryParams.courAvhours"
          placeholder="请输入可用改分时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否需要marker" prop="courNeedmarker">
        <el-input
          v-model="queryParams.courNeedmarker"
          placeholder="请输入是否需要marker"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程评估数量" prop="courNumass">
        <el-input
          v-model="queryParams.courNumass"
          placeholder="请输入课程评估数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="课程评估种类" prop="courTypeass">
        <el-input
          v-model="queryParams.courTypeass"
          placeholder="请输入课程评估种类"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="marker时间" prop="courMarkerhour">
        <el-input
          v-model="queryParams.courMarkerhour"
          placeholder="请输入marker时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="tutor时间" prop="courTutorhour">
        <el-input
          v-model="queryParams.courTutorhour"
          placeholder="请输入tutor时间"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="希望marker数量" prop="courPrenummarker">
        <el-input
          v-model="queryParams.courPrenummarker"
          placeholder="请输入希望marker数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['course:course:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['course:course:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['course:course:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['course:course:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="courseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="课程id" align="center" prop="courId" />
      <el-table-column label="课程编号" align="center" prop="courCode" />
      <el-table-column label="预估学生人数" align="center" prop="courEsti" />
      <el-table-column label="目前学生人数" align="center" prop="courCurrent" />
      <el-table-column label="可用改分时间" align="center" prop="courAvhours" />
      <el-table-column label="是否需要marker" align="center" prop="courNeedmarker" />
      <el-table-column label="课程评估数量" align="center" prop="courNumass" />
      <el-table-column label="课程评估种类" align="center" prop="courTypeass" />
      <el-table-column label="marker时间" align="center" prop="courMarkerhour" />
      <el-table-column label="tutor时间" align="center" prop="courTutorhour" />
      <el-table-column label="marker的职责" align="center" prop="courMarkerrespon" />
      <el-table-column label="希望marker数量" align="center" prop="courPrenummarker" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['course:course:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['course:course:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改课程信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="课程编号" prop="courCode">
          <el-input v-model="form.courCode" placeholder="请输入课程编号" />
        </el-form-item>
        <el-form-item label="预估学生人数" prop="courEsti">
          <el-input v-model="form.courEsti" placeholder="请输入预估学生人数" />
        </el-form-item>
        <el-form-item label="目前学生人数" prop="courCurrent">
          <el-input v-model="form.courCurrent" placeholder="请输入目前学生人数" />
        </el-form-item>
        <el-form-item label="可用改分时间" prop="courAvhours">
          <el-input v-model="form.courAvhours" placeholder="请输入可用改分时间" />
        </el-form-item>
        <el-form-item label="是否需要marker" prop="courNeedmarker">
          <el-input v-model="form.courNeedmarker" placeholder="请输入是否需要marker" />
        </el-form-item>
        <el-form-item label="课程评估数量" prop="courNumass">
          <el-input v-model="form.courNumass" placeholder="请输入课程评估数量" />
        </el-form-item>
        <el-form-item label="课程评估种类" prop="courTypeass">
          <el-input v-model="form.courTypeass" placeholder="请输入课程评估种类" />
        </el-form-item>
        <el-form-item label="marker时间" prop="courMarkerhour">
          <el-input v-model="form.courMarkerhour" placeholder="请输入marker时间" />
        </el-form-item>
        <el-form-item label="tutor时间" prop="courTutorhour">
          <el-input v-model="form.courTutorhour" placeholder="请输入tutor时间" />
        </el-form-item>
        <el-form-item label="marker的职责" prop="courMarkerrespon">
          <el-input v-model="form.courMarkerrespon" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="希望marker数量" prop="courPrenummarker">
          <el-input v-model="form.courPrenummarker" placeholder="请输入希望marker数量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCourse, getCourse, delCourse, addCourse, updateCourse } from "@/api/course/course";

export default {
  name: "Course",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 课程信息表格数据
      courseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        courCode: null,
        courEsti: null,
        courCurrent: null,
        courAvhours: null,
        courNeedmarker: null,
        courNumass: null,
        courTypeass: null,
        courMarkerhour: null,
        courTutorhour: null,
        courMarkerrespon: null,
        courPrenummarker: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        courCode: [
          { required: true, message: "课程编号不能为空", trigger: "blur" }
        ],
        courAvhours: [
          { required: true, message: "可用改分时间不能为空", trigger: "blur" }
        ],
        courNeedmarker: [
          { required: true, message: "是否需要marker不能为空", trigger: "blur" }
        ],
        courPrenummarker: [
          { required: true, message: "希望marker数量不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询课程信息列表 */
    getList() {
      this.loading = true;
      listCourse(this.queryParams).then(response => {
        this.courseList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        courId: null,
        courCode: null,
        courEsti: null,
        courCurrent: null,
        courAvhours: null,
        courNeedmarker: null,
        courNumass: null,
        courTypeass: null,
        courMarkerhour: null,
        courTutorhour: null,
        courMarkerrespon: null,
        courPrenummarker: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.courId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加课程信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const courId = row.courId || this.ids
      getCourse(courId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改课程信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.courId != null) {
            updateCourse(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCourse(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const courIds = row.courId || this.ids;
      this.$modal.confirm('是否确认删除课程信息编号为"' + courIds + '"的数据项？').then(function() {
        return delCourse(courIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('course/course/export', {
        ...this.queryParams
      }, `course_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>


