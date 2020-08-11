package main;

//Using Builder Pattern
public class ImmutableEmployee {

	private final String name;
	private final String city;

	private ImmutableEmployee(Builder builder) {
		this.name = builder.name;
		this.city = builder.city;
	}

	public String getName() {
		return name;
	}

	public String getCity() {
		return city;
	}

	public Builder toBuilder() {
		return new Builder(this);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {

		private String name;
		private String city;

		public Builder() {
		}

		public Builder(ImmutableEmployee employee) {
			this.name = employee.name;
			this.city = employee.city;
		}

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setCity(String city) {
			this.city = city;
			return this;
		}

		public ImmutableEmployee build() {
			return new ImmutableEmployee(this);
		}
	}

}
